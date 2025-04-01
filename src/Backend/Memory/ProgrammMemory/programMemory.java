package Backend.Memory.ProgrammMemory;

/**
 * Program Memory is a memory that stores all the executable instructions.
 * It has 1024 memory locations.
 * Each memory location can store a 14-bit instruction.
 */
public class programMemory {
    // Memory for all executable instructions
    private final int[] memory = new int[1024];

    /**
     * Writes an instruction to the program memory
     *
     * @param address Address of the instruction
     * @param instruction   Instruction to be written
     */
    public void write(int address, int instruction) {
        int effectiveAddress = address & 0x3FF; // mask to 10 bits (Address)
        memory[effectiveAddress] = instruction & 0x3FFF; // mask to 14 bits (Instruction)
    }

    /**
     * Reads an instruction from the program memory
     *
     * @param address Address of the instruction
     * @return Instruction at the given address
     */
    public int read(int address) {
        int effectiveAddress = address & 0x3FF; // mask to 10 bits (Address)
        return memory[effectiveAddress] & 0x3FFF; // mask to 14 bits (Instruction)
    }

    /**
     * Returns the size of the program memory
     *
     * @return Size of the program memory
     */
    public int getSize() {
        return memory.length;
    }

    /**
     * Loads a program into the program memory
     *
     * @param instructions Array of instructions to be loaded
     */
    public void loadProgram(int[] instructions) {
        if (instructions.length > memory.length) {
            System.out.println("Program is too large for memory.\n");
            return;
        }
        for (int i = 0; i < instructions.length; i++) {
            write(i, instructions[i]);
        }
    }
}
