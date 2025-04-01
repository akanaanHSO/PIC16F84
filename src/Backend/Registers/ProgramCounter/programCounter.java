package Backend.Registers.ProgramCounter;

/**
 *  Program Counter is a 13-Bit register that holds the address of the next instruction.
 *  Addresses are 10-bit long (0x000 - 0x3FF).
 *  The Low Byte is the PCL register (readable and writable).
 *  The High Byte is the PCLATH register (not directly readable nor writable).
 */
public class programCounter {
    static final int MASK13 = 0x1FFF; // 13 bits
    static final int MASK5 = 0x1F; // 5 bits
    static final int MASK8 = 0xFF; // 8 bits
    static final int MASK11 = 0x7FF; // 11 bits

    private int pc;
    private int pclath;

    public programCounter() {
        this.pc = 0;
        this.pclath = 0;
    }

    // *PC*

    /**
     * Returns the current program counter value (13 bits).
     *
     * @return Program counter value
     */
    public int getPC() {
        return pc & MASK13;
    }

    /**
     * Sets the program counter to a specific value (13 bits).
     *
     * @param address Address to set the program counter to
     */
    public void setPC(int address) {
        pc = address & MASK13;
    }

    /**
     * Increments the program counter by 1 (13 bits).
     */
    public void increment() {
        pc = (pc + 1) & MASK13;
    }

    // *PCL*

    /**
     * Returns the current PCL (low byte of the program counter).
     *
     * @return PCL value
     */
    public int getPCL() {
        return pc & MASK8;
    }

    /**
     * Sets the PCL (low byte of the program counter) to a specific value.
     *
     * @param value to set the PCL to
     */
    public void setPCL(int value) {
        pc = ((pclath & MASK5) << 8 | (value & MASK8));
    }

    // *PCLATH*

    /**
     * Returns the current PCLATH (high byte "5 bits" of the program counter).
     *
     * @return PCLATH value
     */
    public int getPCLATH() {
        return pclath & MASK5;
    }

    /**
     * Sets the PCLATH (high byte "5 bits" of the program counter) to a specific value.
     *
     * @param value to set the PCLATH to
     */
    public void setPCLATH(int value) {
        pclath = value & MASK5;
    }

    // helper method (13 bits)
    public int getPclathHighBits() {
        int pclathBits =  (pclath & 0x18) >> 3; // PCLATH<4:3>
        return pclathBits << 11;
    }

    /**
     * Jumps to a specific address (used for GOTO and CALL instructions).
     *
     * @param address Address (11 bits) to jump to
     */
    public void jumpTo(int address) {
        int newPC = getPclathHighBits() | (address & MASK11);
        setPC(newPC);
    }

    /**
     * Resets the program counter to 0.
     */
    public void reset() {
        pc = 0;
    }
}
