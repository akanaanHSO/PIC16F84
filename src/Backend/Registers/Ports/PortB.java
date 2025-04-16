package Backend.Registers.Ports;

/**
 * PortB Input/Output Register (8 bits) on bank 0.
 * Bit 0 = RB0
 * Bit 1 = RB1
 * Bit 2 = RB2
 * Bit 3 = RB3
 * Bit 4 = RB4
 * Bit 5 = RB5
 * Bit 6 = RB6
 * Bit 7 = RB7
 */
public class PortB {
    private final int[] port = new int[8];

    public PortB() {
        for (int i = 0; i < port.length; i++) {
            port[i] = 1;
        }
    }

    public void setPin(int value, int pin) {
        port[pin] = value & 0x01;
    }

    public int getPin(int pin) {
        return port[pin];
    }

    public void reset() {
        for (int i = 0; i < port.length; i++) {
            port[i] = 1;
        }
    }

    public int[] getPort() {
        return port;
    }
}
