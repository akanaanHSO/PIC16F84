package Backend.Registers.Ports;

/**
 * TrisA Input/Output Register (5 Bits) on bank 1.
 * This register is used to set the direction of the pins of PortA.
 * 1 = input, 0 = output.
 */
public class TrisA {
    private int tris = 0x1F; // default value is 0x1F (all pins are input) = 1

    public void setTris(int tris) {
        this.tris = tris & 0x1F;
    }

    public int getTris() {
        return tris & 0x1F;
    }
}
