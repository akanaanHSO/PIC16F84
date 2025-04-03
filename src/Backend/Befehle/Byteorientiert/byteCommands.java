package Backend.Befehle.Byteorientiert;

import Backend.Memory.DataMemory.dataMemory;
import Backend.Registers.StatusRegister.statusRegister;
import Backend.Registers.WorkingRegister.workingRegister;

public class byteCommands {
    
    /**
     * Adds working register and content of f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void ADDWF( int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int w = wReg.read();
        int result = w + data.readData(f, RP0);

        status.setCarryFlag(result > 0xFF);
        status.setDigitCarryFlag(((w & 0x0F) + (data.readData(f, RP0) & 0x0F)) > 0x0F);
        status.setZeroFlag((result & 0xFF) == 0);

        if(d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f, result, RP0);
        }

    }

    /**
     * AND-Connection between Working register and content of f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void ANDWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int w = wReg.read();

        int result = w & data.readData(f, RP0);

        status.setZeroFlag((result & 0xFF) == 0);

        if(d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f,result,RP0);
        }
    }

    /**
     * Clears content of f
     * @param f
     */
    public static void CLRF(int f, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        data.writeData(f, 0, RP0);
    }

    /**
     * Clears working register
     * @param wReg
     */
    public static void CLRW(workingRegister wReg) {
        wReg.write(0);
    }

    /**
     * Forms complement of content of f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void COMF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int result = (~f)+1;

        status.setZeroFlag((result & 0xFF) == 0);

        if(d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f, result, RP0);
        }

    }

    /**
     * Decrements content of f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void DECF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int result = data.readData(f, RP0) - 1;
        status.setZeroFlag((result & 0xFF) == 0);
        if(d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f,result,RP0);
        }
    }

    /**
     * Decrements content of f, skips next instruction if result is zero
     * @param f
     * @param d destination
     */
    public static void DECFSZ(int f, int d) {

    }

    /**
     * Increments content of f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void INCF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int result = data.readData(f, RP0) + 1;
        status.setZeroFlag((result & 0xFF) == 0);
        if(d == 0) {
            wReg.write(result); 
        } else {
            data.writeData(f, result, RP0);
        }
    }

    /**
     * Increments content of f, skips next instruction if result is zero
     * @param f
     * @param d
     */
    public static void INCFSZ(int f, int d) {

    }

    /**
     * OR-connection between working register and content of f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void IORWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int result = wReg.read() | data.readData(f, RP0);

        status.setZeroFlag((result & 0xFF) == 0);

        if(d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f,result,RP0);
        }
    }

    /**
     * Gets value from f
     * @param f
     * @param d destination
     */
    public static void MOVF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        wReg.write(data.readData(f, RP0));
    }

    /**
     * Writes content of working register to f
     * @param f
     * @param wReg
     */
    public static void MOVWF(int f, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        data.writeData(f, wReg.read(), RP0);
    }

    /**
     * No Operation
     */
    public static void NOP() {

    }

    /**
     * Rotates content of f to the left through carry
     * @param f
     * @param d destination
     */
    public static void RLF(int f, int d, statusRegister status, dataMemory data) {

    }

    /**
     * Rotates content of f to the right through carry
     * @param f
     * @param d destination
     */
    public static void RRF(int f, int d, statusRegister status, dataMemory data) {

    }

    /**
     * Subtracts working register from content of f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void SUBWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;

        int w = wReg.read();
        int result = data.readData(f, RP0) - w;

        status.setCarryFlag(result < 0);
        status.setDigitCarryFlag(((w & 0x0F) - (data.readData(f, RP0) & 0x0F)) < 0);
        status.setZeroFlag((result & 0xFF) == 0);

        if(d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f,result,RP0);
        }
    }

    /**
     * Swaps both halfbytes at f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void SWAPF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int leftWord = data.readData(f, RP0) & 0b1111<<4;
        int rightWord = data.readData(f, RP0) & 0b00001111;
        int result = leftWord >> 4 + rightWord << 4;
        status.setZeroFlag((result & 0xFF) == 0);
        if (d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f, result, RP0);
        }
    }

    /**
     * EXCLUSIVE-OR of working register and f
     * @param f
     * @param d destination-bit (0 = wReg, 1 = f)
     * @param wReg working register
     * @param status status register
     * @param data data memory
     */
    public static void XORWF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int result = wReg.read() ^ data.readData(f, RP0);

        if(d == 0) {
            wReg.write(result);
        } else {
            data.writeData(f,result,RP0);
        }
    }

}
