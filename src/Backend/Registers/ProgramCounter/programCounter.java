package Backend.Registers.ProgramCounter;

/**
 *  Program Counter is a register that holds the address of the next instruction
 */
public class programCounter {
    private int pc = 0;

    public void increment() {
        pc = (pc + 1) & 0x3FF;
    }

    public void jumpTo(int address) {
        pc = address & 0x3FF;
    }

    public int getProgramCounter() {
        return pc;
    }

    public void reset() {
        pc = 0;
    }
}
