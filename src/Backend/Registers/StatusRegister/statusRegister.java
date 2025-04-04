package Backend.Registers.StatusRegister;

/**
 * The Zero flag is set when the result of an operation is 0.
 * The Carry flag is set when the result of an operation has a carry (overflow) in the most significant bit (MSB).
 * The Digit Carry (Half carry) flag is set when the result of an operation has a carry in the lower nibble (4 bits).
 * Bit0 = Carryflag,
 * Bit1 = DC-Flag,
 * Bit2 = Zero-Flag,
 * Bit3 = Power-Down-Bit,
 * Bit4 = Time-Out-Bit,
 * Bit5 = RP0
 * Bit6 = RP1 (Bei mehr als 2 Bänken notwendig)
 * Bit7 = IRP (Bei mehr als 2 Bänken notwendig)
 */
public class statusRegister {
    // Flags
    private final int[] flags;

    public statusRegister() {
        this.flags = new int[8];
        for (int i = 0; i < flags.length; i++) {
            flags[i] = 0;
        }
    }

    // Methoden (Getter und Setter)
    public void setCarryFlag(boolean flag) {
        flags[0] = flag ? 1 : 0;
    }

    public void setDigitCarryFlag(boolean flag) {
        flags[1] = flag ? 1 : 0;
    }
    
    public void setZeroFlag(boolean flag) {
        flags[2] = flag ? 1 : 0;
    }

    public void setPowerDownBit(boolean flag) {
        flags[3] = flag ? 1 : 0;
    }

    public void setTimeOutBit(boolean flag) {
        flags[4] = flag ? 1 : 0;
    }

    /**
     * True = Bank1, False = Bank0
     * @param flag true / false
     */
    public void setRP0(boolean flag) {
        flags[5] = flag ? 1 : 0;
    }

    public void setRP1(boolean flag) {
        flags[6] = flag ? 1 : 0;
    }

    public void setIRP(boolean flag) {
        flags[7] = flag ? 1 : 0;
    }


    public boolean getCarryFlag() {
        return flags[0] == 1;
    }

    public boolean getDigitcarryFlag() {
        return flags[1] == 1;
    }

    public boolean getZeroFlag() {
        return flags[2] == 1;
    }

    public boolean getPowerDownBit() {
        return flags[3] == 1;
    }

    public boolean getTimeOutBit() {
        return flags[4] == 1;
    }

    public boolean getRP0() {
        return flags[5] == 1;
    }

    public boolean getRP1() {
        return flags[6] == 1;
    }

    public boolean getIRP() {
        return flags[7] == 1;
    }
}
