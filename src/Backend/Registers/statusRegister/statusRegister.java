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
    // Flags
    int flags[] = new int[3];

    // Methoden (Getter und Setter)
    public void setZeroFlag(int flag) {
        flags[0] = flag;
    }

    public void setCarryFlag(int flag) {
        flags[1] = flag;
    }

    public void setNegativeFlag(int flag) {
        flags[2] = flag;
    }

    public int getZeroFlag() {
        return flags[0];
    }

    public int getCarryFlag() {
        return flags[1];
    }

    public int getNegativeFlag() {
        return flags[2];
    }
}
