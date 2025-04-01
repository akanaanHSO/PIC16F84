package Backend.Registers.InstructionRegister;

/**
 * Instruction Register is a register that stores the current 14-bit instruction fetched from the program memory.
 * It is a 14-bit register.
 * The instruction is then decoded by the decoder.
 */
public class instructionRegister {
    private int instruction; // 14 bits

    /**
     * Constructor for instruction register
     */
    public instructionRegister() {
        this.instruction = 0;
    }

    /**
     * Writes an instruction to the instruction register
     *
     * @param instruction Instruction to be written
     */
    public void loadInstruction(int instruction) {
        this.instruction = instruction & 0x3FFF; // mask to 14 bits
    }

    /**
     * Reads the instruction from the instruction register
     *
     * @return Instruction in the instruction register
     */
    public int getInstruction() {
        return instruction & 0x3FFF; // mask to 14 bits
    }

    /**
     * resets the instruction register
     */
    public void reset() {
        this.instruction = 0;
    }
}
