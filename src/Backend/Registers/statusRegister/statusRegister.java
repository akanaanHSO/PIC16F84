package Backend.Registers.statusRegister;

// Hier soll es drei wichtige Flags geben, die wir in der ALU benötigen.
// Diese sind das Zero-Flag, das Carry-Flag und das Negative-Flag.
// Diese Flags sollen in einem Integer-Array gespeichert werden.
/*
* Das Zero-Flag wird gesetzt, wenn das Ergebnis einer Operation 0 ist.
* Das Carry-Flag wird gesetzt, wenn das Ergebnis einer Operation einen Übertrag hat.
* Das Negative-Flag wird gesetzt, wenn das Ergebnis einer Operation negativ ist.
* */
public class statusRegister {

    /**
     * Bit0 = Carryflag,
     * Bit1 = DC-Flag,
     * Bit2 = Zero-Flag,
     * Bit3 = Power-Down-Bit,
     * Bit4 = Time-Out-Bit,
     * Bit5 = RP0
     * Bit6 = RP1 (Bei mehr als 2 Bänken notwendig)
     * Bit7 = IRP (Bei mehr als 2 Bänken notwendig)
     **/

    // Flags
    int flags[] = new int[8];

    // Methoden (Getter und Setter)
    public void setCarryFlag(int flag) {
        flags[0] = flag;
    }

    public void setDigitcarryFlag(int flag) {
        flags[1] = flag;
    } 
    
    public void setZeroFlag(int flag) {
        flags[2] = flag;
    }

    public void setPowerDownBit(int flag) {
        flags[3] = flag;
    }

    public void setTimeOutBit(int flag) {
        flags[4] = flag;
    }

    public void setRP0(int flag) {
        flags[5] = flag;
    }

    public void setRP1(int flag) {
        flags[6] = flag;
    }

    public void setIRP(int flag) {
        flags[7] = flag;
    }    

    

    public int getCarryFlag() {
        return flags[0];
    }

    public int getDigitcarryFlag() {
        return flags[1];
    }

    public int getZeroFlag() {
        return flags[2];
    }

    public int getPowerDownBit() {
        return flags[3];
    }

    public int getTimeOutBit() {
        return flags[4];
    }

    public int getRP0() {
        return flags[5];
    }

    public int getRP1() {
        return flags[6];
    }

    public int getIRP() {
        return flags[7];
    }
}
