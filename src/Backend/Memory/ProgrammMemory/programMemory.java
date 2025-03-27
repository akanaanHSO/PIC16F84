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
        if (address >= 0 && address < 1024) {
            memory[address] = instruction & 0x3FFF; // mask to 14 bits
        } else {
            System.out.println("Invalid address in program memory.\n");
        }
    }

    /**
     * Reads an instruction from the program memory
     *
     * @param address Address of the instruction
     * @return Instruction at the given address
     */
    public int read(int address) {
        if (address >= 0 && address < 1024) {
            return memory[address];
        } else {
            System.out.println("Invalid address in program memory.\n");
            return 0;
        }
    }
}
