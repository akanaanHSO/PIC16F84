package Backend.Befehle.Literal;

import Backend.Befehle.Instruction;
import Backend.Registers.StatusRegister.statusRegister;
import Backend.Registers.WorkingRegister.workingRegister;
import Backend.Memory.Stack.stackMemory;
import Backend.Registers.ProgramCounter.programCounter;
import Backend.Interrupt.interruptController;

/**
 * Literal and Control Commands.
 */

public class literalCommands {
    public static void execute(Instruction instruction, workingRegister wReg, statusRegister status, programCounter pc, stackMemory stack, interruptController intCtrl) {
        Instruction.OperationCode opcode = instruction.getOpcode();
        int[] args = instruction.getArguments();

        switch (opcode) {
            case ADDLW -> ADDLW(args[0], wReg, status);
            case ANDLW -> ANDLW(args[0], wReg, status);
            case SUBLW -> SUBLW(args[0], wReg, status);
            case IORLW -> IORLW(args[0], wReg, status);
            case XORLW -> XORLW(args[0], wReg, status);
            case GOTO -> GOTO(args[0], pc);
            case CALL -> CALL(args[0], pc, stack);
            case MOVLW -> MOVLW(args[0], wReg);
            case RETLW -> RETLW(args[0], wReg, pc, stack);
            case RETURN -> RETURN(pc, stack);
            case RETFIE -> RETFIE(pc, stack, intCtrl);
            case SLEEP -> SLEEP(status);
            case CLRWDT -> CLRWDT(status);
            default -> throw new IllegalArgumentException("Invalid opcode: " + opcode);
        }
    }

    /**
     * ADDLW adds the literal k to the working register.
     */
    public static void ADDLW (int k, workingRegister wReg, statusRegister status) {
        int w = wReg.read();
        int result = w + k;
        status.setCarryFlag(result > 0xFF);
        status.setDigitCarryFlag(((w & 0x0F) + (k & 0x0F)) > 0x0F);
        status.setZeroFlag((result & 0xFF) == 0);
        wReg.write(result & 0xFF);
    }

    /**
     * ANDLW performs a bitwise AND operation between the literal k and the working register.
     */
    public static void ANDLW (int k, workingRegister wReg, statusRegister status) {
        int w = wReg.read();
        int result = w & k;
        status.setZeroFlag(result == 0);
        wReg.write(result & 0xFF);
    }

    /**
     * SUBLW subtracts the literal k from the working register.
     */
    public static void SUBLW (int k, workingRegister wReg, statusRegister status) {
        int w = wReg.read();
        int result = (k - w) & 0xFF;
        status.setCarryFlag(k >= w);
        status.setDigitCarryFlag((k & 0x0F) >= (w & 0x0F));
        status.setZeroFlag((result & 0xFF) == 0);
        wReg.write(result & 0xFF);
    }

    /**
     * IORLW performs a bitwise OR operation between the literal k and the working register.
     */
    public static void IORLW (int k, workingRegister wReg, statusRegister status) {
        int w = wReg.read();
        int result = w | k;
        status.setZeroFlag(result == 0);
        wReg.write(result & 0xFF);
    }

    /**
     * XORLW performs a bitwise XOR operation between the literal k and the working register.
     */
    public static void XORLW (int k, workingRegister wReg, statusRegister status) {
        int w = wReg.read();
        int result = w ^ k;
        status.setZeroFlag(result == 0);
        wReg.write(result & 0xFF);
    }

    /**
     * GOTO jumps to the address.
     */
    public static void GOTO (int address, programCounter pc) {
        pc.jumpTo(address);
    }

    /**
     * CALL calls the subroutine at the address.
     */
    public static void CALL (int address, programCounter pc, stackMemory stack) {
        int returnAddress = pc.getPC();
        stack.push(returnAddress);
        pc.jumpTo(address);
    }

    /**
     * MOVLW writes the literal k to the working register.
     */
    public static void MOVLW (int k, workingRegister wReg) {
            wReg.write(k & 0xFF);
        }

    /**
     * RETLW returns the literal k from sub-program to working register.
     */
    public static void RETLW (int k, workingRegister wReg, programCounter pc, stackMemory stack) {
        wReg.write(k & 0xFF);
        int returnAddress = stack.pop();
        pc.setPC(returnAddress);
    }

    /**
     * RETURN returns from sub-program.
     */
    public static void RETURN (programCounter pc, stackMemory stack) {
        int returnAddress = stack.pop();
        pc.setPC(returnAddress);
    }

    /**
     * RETFIE returns from interrupt.
     */
    public static void RETFIE (programCounter pc, stackMemory stack, interruptController intCtrl) {
        int returnAddress = stack.pop();
        pc.setPC(returnAddress);
        if (intCtrl != null) {
            //intCtrl.enableGlobalInterrupt(); // set GIE-Bit to 1 (activate global interrupt)
        }
    }

    /**
     * SLEEP sets the power-down bit in the status register.
     */
    public static void SLEEP (statusRegister status) {
        status.setPowerDownBit(true);
    }

    /**
     * CLRWDT clears the watchdog timer.
     */
    public static void CLRWDT (statusRegister status) {
        status.setTimeOutBit(false);
    }
}