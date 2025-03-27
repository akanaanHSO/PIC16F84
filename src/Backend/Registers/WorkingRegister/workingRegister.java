package Backend.Registers.WorkingRegister;

/**
 * Working Register is a register that is used to store the data that is being
 * manipulated by the ALU. It is also used to store the intermediate results of
 * the operations. It is an 8-bit register.
 */
public class workingRegister {
    private int value = 0;

    public void write(int value) {
        this.value = value & 0xFF; // only 8 bits are used
    }

    public int read() {
        return value;
    }
}
