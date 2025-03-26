package Backend.Memory.ProgrammMemory;

/**
 * Program Memory is a memory that stores all the executable instructions.
 * It has 1024 memory locations.
 * Each memory location can store a 14-bit instruction.
 */
public class programMemory {
    // Memory for all executable instructions
    private final int[] memory = new int[1024];

    public void write(int address, int value) {
        if (address >= 0 && address < 1024) {
            memory[address] = value & 0x3FFF;
        } else {
            System.out.println("Invalid address in program memory.\n");
        }
    }

    public int read(int address) {
        if (address >= 0 && address < 1024) {
            return memory[address];
        } else {
            System.out.println("Invalid address in program memory.\n");
            return 0;
        }
    }
}
