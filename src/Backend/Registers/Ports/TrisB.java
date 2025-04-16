package Backend.Registers.Ports;

/**
 * TrisB Input/Output Register (8 Bits) on bank 1.
 * This register is used to set the direction of the pins of PortB.
 * 1 = input, 0 = output.
 */
public class TrisB {
    private int tris = 0xFF; // default value is 0xFF (all pins are input) = 1

    public void setTris(int tris) {
        this.tris = tris & 0xFF;
    }

    public int getTris() {
        return tris;
    }
}
