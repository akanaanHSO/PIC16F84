package Backend.Befehle.Bitorientiert;

import Backend.Befehle.Instruction;
import Backend.Registers.ProgramCounter.programCounter;
import Backend.Memory.DataMemory.dataMemory;

public class bitCommands {

    public static void execute(Instruction instruction, dataMemory data, programCounter pc) {
        Instruction.OperationCode opcode = instruction.getOpcode();
        int[] args = instruction.getArguments();

        switch (opcode) {
            case BCF -> BCF(args[0], args[1], data);
            case BSF -> BSF(args[0], args[1], data);
            case BTFSC -> BTFSC(args[0], args[1], data, pc);
            case BTFSS -> BTFSS(args[0], args[1], data, pc);
            default -> { throw new IllegalArgumentException("Invalid opcode: " + opcode);}
        }
    }
    /**
     * Bit-Clear at Address f
     */
    public static void BCF(int f, int b, dataMemory data) {
        int bits = data.readData(f) & ~(1 << b);
        data.writeData(f, bits & 0xFF);
    }

    /**
     * Bit-Set at Address f
     */
    public static void BSF (int f, int b, dataMemory data) {
        int bits = data.readData(f) | (1 << b);
        data.writeData(f, bits & 0xFF);
    }

    /**
     * Bit Test Address F, Skip if Clear
     */
    public static void BTFSC (int f, int b, dataMemory data, programCounter pc) {
        int dataBit = (data.readData(f) >> b) & 1;
        if (dataBit == 0){
            //Skip next instruction, execute NOP
            pc.increment();
        }
    }

    /**
     * Bit Test Address F, Skip if Set
     */
    public static void BTFSS (int f, int b, dataMemory data, programCounter pc) {
        int dataBit = (data.readData(f) >> b) & 1;
        if (dataBit == (1 << b)) {
            //Skip next instruction, execute a NOP
            pc.increment();
        }
    }
}
