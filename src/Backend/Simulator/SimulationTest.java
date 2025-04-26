package Backend.Simulator;

import Backend.Memory.DataMemory.dataMemory;
import Backend.Memory.ProgrammMemory.programMemory;
import Backend.Memory.Stack.stackMemory;
import Backend.Registers.InstructionRegister.instructionRegister;
import Backend.Registers.ProgramCounter.programCounter;
import Backend.Registers.StatusRegister.statusRegister;
import Backend.Registers.WorkingRegister.workingRegister;
import Backend.Dekoder.readFile;

import Backend.Befehle.Byteorientiert.byteCommands;
import Backend.Befehle.Literal.literalCommands;

public class SimulationTest {

    static workingRegister wReg = new workingRegister();
    static instructionRegister iReg = new instructionRegister();
    static statusRegister sReg = new statusRegister();

    static dataMemory data = new dataMemory(sReg);
    static programMemory prog = new programMemory();
    static stackMemory stack = new stackMemory();


    static programCounter pc = new programCounter();
    static readFile file = new readFile();

    public static void main(String[] args) {

        System.out.println("Available program memory: "+prog.getSize()+" Bytes");

        //Testing Stack
        stack.push(0xFABA);
        stack.push(0xFA3C);
        stack.push(0xFFFF);
        System.out.println(0xFFFF + " " + (0xFFFF & 0x1FFF) + " " + stack.pop());
        System.out.println(0xFA3C + " " + (0xFA3C & 0x1FFF) + " " + stack.pop());
        System.out.println(0xFABA + " " + (0xFABA & 0x1FFF) + " " + stack.pop());

        //Testing Bank
        sReg.setRP0(false);
        System.out.println("Currently in Bank "+whichBank()+".");

        //Writing to Bank0
        data.writeData(0x0C, 0x6F);
        data.writeData(0x0F, 0x8F);
        data.writeData(0x0B, 0xAF);

        System.out.println("Data in Bank "+whichBank()+" at adress 0x0C: "+data.readData(0x0C));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0F: "+data.readData(0x0F));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0B: "+data.readData(0x0B));
        
        //Switching Bank
        sReg.setRP0(true);

        //Reading data in Bank1
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0C: "+data.readData(0x0C));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0F: "+data.readData(0x0F));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0B: "+data.readData(0x0B));

        //Writing to Bank1
        data.writeData(0x0C, 0xF6);
        data.writeData(0x0F, 0xF8);
        data.writeData(0x0B, 0xFA);

        System.out.println("Data in Bank "+whichBank()+" at adress 0x0C: "+data.readData(0x0C));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0F: "+data.readData(0x0F));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0B: "+data.readData(0x0B));

        //Testing working Register and commands
        //Literal
        System.out.println("Content of Working Register: "+wReg.read());

        literalCommands.ADDLW(0x0F, wReg, sReg); //Adding 15 to wReg

        System.out.println("Content of Working Register: "+wReg.read());

        literalCommands.SUBLW(0x0A, wReg, sReg); //Subtracting 10

        System.out.println("Content of Working Register: "+wReg.read());

        //Byte

        System.out.println("Data in Bank "+whichBank()+" at adress 0x10: "+data.readData(0x10));

        byteCommands.MOVWF(0x10, wReg, sReg, data); //Writing wReg to adress 0x10 at Bank1

        System.out.println("Data in Bank "+whichBank()+" at adress 0x10: "+data.readData(0x10));

        byteCommands.CLRW(wReg); //Clearing wReg

        System.out.println("Content of Working Register: "+wReg.read());
        
        byteCommands.ADDWF(0x10,0,wReg,sReg,data); //Adding content of adress 0x10 at Bank1 to wReg

        System.out.println("Content of Working Register: "+wReg.read());
        
        sReg.setRP0(false); //Switch to Bank 0
        byteCommands.ADDWF(0x0C,0,wReg,sReg,data); //Adding content of adress 0x0C at Bank0 to wReg

        System.out.println("Content of Working Register: "+wReg.read());

        //Filereader Test

        file.readToProgramMem(prog,"src\\Backend\\Simulator\\Test.LST");
        
        for(int i = 0; i < 17; i++) {
            Integer.toHexString(i);
            String hexString = String.format("%03x", i);
            String binaryString = Integer.toBinaryString(prog.read(i));
            System.out.println("Instruction at Adress 0x"+hexString+": "+binaryString);
        }
    }
 
    static int whichBank() {
        return sReg.getRP0() ? 1 : 0;
    }

}
