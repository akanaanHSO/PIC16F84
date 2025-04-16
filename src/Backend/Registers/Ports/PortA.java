package Backend.Registers.Ports;

/**
 * PortA Input/Output Register (5 bits)  on bank 0.
 * Bit 0 = RA0
 * Bit 1 = RA1
 * Bit 2 = RA2
 * Bit 3 = RA3
 * Bit 4 = RA4
 */
public class PortA {
    private final int[] port = new int[5];

    public PortA() {
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
