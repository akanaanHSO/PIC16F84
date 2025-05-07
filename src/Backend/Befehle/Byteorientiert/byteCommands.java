package Backend.Befehle.Byteorientiert;

import Backend.Befehle.Instruction;
import Backend.Interrupt.interruptController;
import Backend.Memory.DataMemory.dataMemory;
import Backend.Memory.Stack.stackMemory;
import Backend.Registers.ProgramCounter.programCounter;
import Backend.Registers.StatusRegister.statusRegister;
import Backend.Registers.WorkingRegister.workingRegister;

public class byteCommands {
    public static void execute(Instruction instruction, workingRegister wReg, statusRegister status, programCounter pc, stackMemory stack, interruptController intCtrl, dataMemory data) {
        Instruction.OperationCode opcode = instruction.getOpcode();
        int[] args = instruction.getArguments();

        switch (opcode) {
            case ADDWF -> ADDWF(args[0], args[1], wReg, status, data);
            case ANDWF -> ANDWF(args[0], args[1], wReg, status, data);
            case CLRF -> CLRF(args[0], status, data);
            case CLRW -> CLRW(wReg, status);
            case COMF -> COMF(args[0], args[1], wReg, status, data);
            case DECF -> DECF(args[0], args[1], wReg, status, data);
            case DECFSZ -> DECFSZ(args[0], args[1], wReg, status, data, pc);
            case INCF -> INCF(args[0], args[1], wReg, status, data);
            case INCFSZ -> INCFSZ(args[0], args[1], wReg, status, data, pc);
            case IORWF -> IORWF(args[0], args[1], wReg, status, data);
            case MOVF -> MOVF(args[0], args[1], wReg, status, data);
            case MOVWF -> MOVWF(args[0], wReg, status, data);
            case NOP -> NOP();
            case RLF -> RLF(args[0], args[1], wReg, status, data);
            case RRF -> RRF(args[0], args[1], wReg, status, data);
            case SUBWF -> SUBWF(args[0], args[1], wReg, status, data);
            case SWAPF -> SWAPF(args[0], args[1], wReg, status, data);
            case XORWF -> XORWF(args[0], args[1], wReg, status, data);
            default -> throw new IllegalArgumentException("Invalid opcode: " + opcode);
        }
    }
    
    /**
     * Adds working register and content of f
     */
    public static void ADDWF( int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int w = wReg.read();
        int result = w + data.readData(f);
        status.setCarryFlag(result > 0xFF);
        status.setDigitCarryFlag(((w & 0x0F) + (data.readData(f) & 0x0F)) > 0x0F);
        status.setZeroFlag((result & 0xFF) == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * AND-Connection between Working register and content of f
     */
    public static void ANDWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int w = wReg.read();
        int result = w & data.readData(f);
        status.setZeroFlag((result & 0xFF) == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Clears content of f
     */
    public static void CLRF(int f, statusRegister status, dataMemory data) {
        data.writeData(f, 0);
        status.setZeroFlag(true);
    }

    /**
     * Clears working register
     */
    public static void CLRW(workingRegister wReg, statusRegister status) {
        wReg.write(0);
        status.setZeroFlag(true);
    }

    /**
     * Forms complement of content of f
     */
    public static void COMF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int result = ~data.readData(f) & 0xFF;
        status.setZeroFlag(result == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Decrements content of f
     */
    public static void DECF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int result = (data.readData(f) - 1) & 0xFF;
        status.setZeroFlag(result == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Decrements content of f, skips next instruction if result is zero
     */
    public static void DECFSZ(int f, int d, workingRegister wReg, statusRegister status, dataMemory data, programCounter pc) {
        int result = (data.readData(f) - 1) & 0xFF;
        status.setZeroFlag(result == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
        if(result == 0) {
            //Skip next instruction, execute a NOP
            pc.increment();
        }
    }

    /**
     * Increments content of f
     */
    public static void INCF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int result = (data.readData(f) + 1) & 0xFF;
        status.setZeroFlag(result == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Increments content of f, skips next instruction if result is zero
     */
    public static void INCFSZ(int f, int d, workingRegister wReg, statusRegister status, dataMemory data, programCounter pc) {
        int result = (data.readData(f) + 1) & 0xFF;
        status.setZeroFlag(result == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
        if(result == 0) {
            //Skip next instruction, execute a NOP
            pc.increment();
        }
    }

    /**
     * OR-connection between working register and content of f
     */
    public static void IORWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int result = wReg.read() | data.readData(f);
        status.setZeroFlag((result & 0xFF) == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Gets value from f
     */
    public static void MOVF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int value = data.readData(f) & 0xFF;
        status.setZeroFlag(value == 0);
        if(d == 0) wReg.write(value);
        else data.writeData(f,value);
    }

    /**
     * Writes content of working register to f
     */
    public static void MOVWF(int f, workingRegister wReg, statusRegister status, dataMemory data) {
        int value = wReg.read() & 0xFF;
        data.writeData(f, value);
    }

    /**
     * No Operation
     */
    public static void NOP() {
    }

    /**
     * Rotates content of f to the left through carry
     */
    public static void RLF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int value = data.readData(f);
        int carry = status.getCarryFlag() ? 1 : 0;
        int result = ((value << 1) | carry) & 0xFF;
        status.setCarryFlag((value & 0x80) != 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Rotates content of f to the right through carry
     */
    public static void RRF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int value = data.readData(f);
        int carry = status.getCarryFlag() ? 1 : 0;
        status.setCarryFlag((value & 0x01) != 0);
        int result = ((value >> 1) | (carry << 7)) & 0xFF;
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Subtracts working register from content of f
     */
    public static void SUBWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int wValue = wReg.read();
        int fValue = data.readData(f);
        int result = (fValue - wValue) & 0xFF;
        status.setCarryFlag(fValue >= wValue);
        status.setDigitCarryFlag((fValue & 0x0F) >= (wValue & 0x0F));
        status.setZeroFlag(result == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * Swaps both halfbytes at f
     */
    public static void SWAPF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int value = data.readData(f);
        int result = ((value & 0x0F) << 4) | ((value & 0xF0) >> 4);
        status.setZeroFlag((result & 0xFF) == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }

    /**
     * EXCLUSIVE-OR of working register and f
     */
    public static void XORWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int result = (wReg.read() ^ data.readData(f)) & 0xFF;
        status.setZeroFlag(result == 0);
        if(d == 0) wReg.write(result);
        else data.writeData(f,result);
    }
}
