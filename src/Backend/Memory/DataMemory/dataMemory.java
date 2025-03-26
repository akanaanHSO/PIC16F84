package Backend.Memory.DataMemory;

/**
 * Data memory is a memory that holds data for the program.
 * It is divided into two banks, bank0 and bank1.
 * Each bank has 128 memory locations.
 */
public class dataMemory {

    private final int[] bank0 = new int[128]; //12-79
    private final int[] bank1 = new int[128]; //140-207

    public void writeData(int address, int data) {
        if (address >= 0 && address < 256) {
            if (address < 128) {
                bank0[address] = data & 0xFF;
            } else {
                bank1[address - 128] = data & 0xFF;
            }
        } else {
            System.out.println("Invalid address in data memory.\n");
        }
    }

    public int readData(int address) {
        if (address >= 0 && address < 256) {
            if (address < 128) {
                return bank0[address];
            } else {
                return bank1[address - 128];
            }
        } else {
            System.out.println("Invalid address in data memory.\n");
            return 0;
        }
    }
}
