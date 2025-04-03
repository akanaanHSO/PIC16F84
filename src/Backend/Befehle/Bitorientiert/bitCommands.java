package Backend.Befehle.Bitorientiert;

import Backend.Befehle.Byteorientiert.byteCommands;
import Backend.Memory.DataMemory.dataMemory;
import Backend.Registers.StatusRegister.statusRegister;

public class bitCommands {
    
    public static void BCF(int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int bits = data.readData(f, RP0) & ~(1 << b);
        data.writeData(f, bits, RP0);
    }

    public static void BSF (int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int bits = data.readData(f, RP0) | (1 << b);
        data.writeData(f, bits, RP0);
    }

    public static void BTFSC (int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int dataBit = data.readData(f, RP0) & (1 << b);
        
        if(dataBit == 0){
            //Skip next instruction, execute NOP
        }
    }

    public static void BTFSS (int f, int b, statusRegister status, dataMemory data) {
        int RP0 = status.getRP0() ? 1 : 0;
        int dataBit = data.readData(f, RP0) & (1 << b);

        if(dataBit == (1 << b)) {
            //Skip next instruction, execute a NOP
        }
    }
    
}
