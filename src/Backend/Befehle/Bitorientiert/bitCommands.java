package Backend.Befehle.Bitorientiert;

import Backend.Memory.DataMemory.dataMemory;
import Backend.Registers.StatusRegister.statusRegister;

public class bitCommands {
    
    /**
     * Bit-Clear at Address f
     * @param f Address
     * @param b bit-position
     * @param status status register
     * @param data data register
     */
    public static void BCF(int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int bits = data.readData(f, RP0) & ~(1 << b);
        data.writeData(f, bits, RP0);
    }

    /**
     * Bit-Set at Address f
     * @param f Address
     * @param b bit-position
     * @param status status register
     * @param data data register
     */
    public static void BSF (int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int bits = data.readData(f, RP0) | (1 << b);
        data.writeData(f, bits, RP0);
    }

    /**
     * Bit Test Address F, Skip if Clear
     * @param f Address
     * @param b bit-position
     * @param status status register
     * @param data data register
     */
    public static void BTFSC (int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int dataBit = data.readData(f, RP0) & (1 << b);
        
        if(dataBit == 0){
            //Skip next instruction, execute NOP
        }
    }

    /**
     * Bit Test Address F, Skip if Set
     * @param f Address
     * @param b bit-position
     * @param status status register
     * @param data data register
     */
    public static void BTFSS (int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int dataBit = data.readData(f, RP0) & (1 << b);

        if(dataBit == (1 << b)) {
            //Skip next instruction, execute a NOP
        }
    }
    
}
