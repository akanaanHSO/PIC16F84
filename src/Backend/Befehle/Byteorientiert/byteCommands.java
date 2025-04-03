package Backend.Befehle.Byteorientiert;

import Backend.Memory.DataMemory.dataMemory;
import Backend.Registers.StatusRegister.statusRegister;
import Backend.Registers.WorkingRegister.workingRegister;

public class byteCommands {
    
    /**
     * Adds working register and f
     * @param f
     * @param wReg
     * @param d destination
     */
    public static void ADDWF( int f, workingRegister wReg, int d, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int w = wReg.read();

        int result = w + data.readData(f, RP0);

    }

    /**
     * AND-Connection between Working register and f
     * @param f
     * @param wReg
     * @param d destination
     */
    public static void ANDWF(int f, workingRegister wReg, int d, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int w = wReg.read();

        int result = w & data.readData(f, RP0);

    }

    /**
     * Clears f
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
     * Forms complement of f
     * @param f
     * @param d destination
     */
    public static void COMF(int f, int d, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int result = (~f)+1;

    }

    /**
     * Decrements f
     * @param f
     * @param d Destination
     */
    public static void DECF(int f, int d, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;

    }

    /**
     * Decrements f, skips next operation if result is zero
     * @param f
     * @param d destination
     */
    public static void DECFSZ(int f, int d) {

    }

    /**
     * Increments f
     * @param f
     * @param d destination
     */
    public static void INCF(int f, int d) {

    }

    /**
     * Increments f, skips next operation if result is zero
     * @param f
     * @param d
     */
    public static void INCFSZ(int f, int d) {

    }

    /**
     * OR-connection between working register and f
     * @param f
     * @param wReg
     * @param d destination
     */
    public static void IORWF(int f, workingRegister wReg, int d) {
        int w = wReg.read();
    }

    /**
     * Gets value from f
     * @param f
     * @param d destination
     */
    public static void MOVF(int f, int d, workingRegister wReg, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        wReg.write();
    }

    /**
     * Writes content of working register to f
     * @param f
     * @param wReg
     */
    public static void MOVWF(int f, workingRegister wReg) {
        int w = wReg.read();
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
    public static void RLF(int f, int d) {

    }

    /**
     * Rotates content of f to the right through carry
     * @param f
     * @param d destination
     */
    public static void RRF(int f, int d) {

    }

    /**
     * Subtracts working register from content of f
     * @param f
     * @param wReg
     * @param d destination
     */
    public static void SUBWF(int f, workingRegister wReg, int d) {
        int w = wReg.read();
    }

    /**
     * Swaps both halfbytes at f
     * @param f
     * @param d destination
     */
    public static void SWAPF(int f, int d) {

    }

    /**
     * EXCLUSIVE-OR of working register and f
     * @param f
     * @param wReg
     * @param d destination
     */
    public static void XORWF(int f, workingRegister wReg, int d) {
        int w = wReg.read();
    }

}
