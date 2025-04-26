package Backend.Memory.DataMemory;

import Backend.Registers.StatusRegister.statusRegister;

/**
 * Data memory is a memory that holds data for the program.
 * It is divided into two banks, bank0 and bank1.
 * Each bank has 128 memory locations. Bank selection via RP0 bit in the status register.
 */
public class dataMemory {

    private final int[] bank0 = new int[128]; //12-79
    private final int[] bank1 = new int[128]; //140-207

    statusRegister statReg;

    /**
     * Constructor for data memory
     */
    public dataMemory(statusRegister statReg) {
        for (int i = 0; i < 128; i++) {
            bank0[i] = 0;
            bank1[i] = 0;
        }
        this.statReg = statReg;
        System.out.println("Data memory initialized");
    }

    /**
     * Writes data to the data memory
     *
     * @param address Address of the data
     * @param data    Data to be written
     */
    public void writeData(int address, int data) {
        if (address >= 0 && address < 128) {
            if (statReg.getRP0()) {
                bank1[address] = data & 0xFF; // mask to 8 bits
            } else if(!statReg.getRP0()) {
                bank0[address] = data & 0xFF; // mask to 8 bits
            } else {
                System.out.println("Invalid RP0 value in data memory.\n");
            }
        } else {
            System.out.println("Invalid address in data memory.\n");
        }
    }

    /**
     * Reads data from the data memory
     *
     * @param address Address of the data
     * @return Data at the given address
     */
    public int readData(int address) {
        if (address >= 0 && address < 128) {
            if (statReg.getRP0()) {
                return bank1[address];
            } else if (!statReg.getRP0()) {
                return bank0[address];
            } else {
                System.out.println("Invalid RP0 value in data memory.\n");
                return 0;
            }
        } else {
            System.out.println("Invalid address in data memory.\n");
            return 0;
        }
    }

    /**
     * Clears the data memory (Reset of controller)
     */
    public void resetMemory() {
        for (int i = 0; i < 128; i++) {
            bank0[i] = 0;
            bank1[i] = 0;
        }
        System.out.println("Data memory cleared");
    }
}
