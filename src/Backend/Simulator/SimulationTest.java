package Backend.Simulator;

import Backend.Memory.DataMemory.dataMemory;
import Backend.Memory.ProgrammMemory.programMemory;
import Backend.Memory.Stack.stackMemory;
import Backend.Registers.InstructionRegister.instructionRegister;
import Backend.Registers.ProgramCounter.programCounter;
import Backend.Registers.StatusRegister.statusRegister;
import Backend.Registers.WorkingRegister.workingRegister;

public class SimulationTest {

    static dataMemory data = new dataMemory();
    static programMemory prog = new programMemory();
    static stackMemory stack = new stackMemory();

    static workingRegister wReg = new workingRegister();
    static instructionRegister iReg = new instructionRegister();
    static statusRegister sReg = new statusRegister();

    static programCounter pc = new programCounter();

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

        data.writeData(0x0C, 0x6F, whichBank());
        data.writeData(0x0F, 0x8F, whichBank());
        data.writeData(0x0B, 0xAF, whichBank());

        System.out.println("Data in Bank "+whichBank()+" at adress 0x0C: "+data.readData(0x0C, whichBank()));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0F: "+data.readData(0x0F, whichBank()));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0B: "+data.readData(0x0B, whichBank()));
        
        //Switching Bank
        sReg.setRP0(true);

        System.out.println("Data in Bank "+whichBank()+" at adress 0x0C: "+data.readData(0x0C, whichBank()));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0F: "+data.readData(0x0F, whichBank()));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0B: "+data.readData(0x0B, whichBank()));

        data.writeData(0x0C, 0xF6, whichBank());
        data.writeData(0x0F, 0xF8, whichBank());
        data.writeData(0x0B, 0xFA, whichBank());

        System.out.println("Data in Bank "+whichBank()+" at adress 0x0C: "+data.readData(0x0C, whichBank()));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0F: "+data.readData(0x0F, whichBank()));
        System.out.println("Data in Bank "+whichBank()+" at adress 0x0B: "+data.readData(0x0B, whichBank()));

        //Testing working Register and commands
        //Literal
        System.out.println("Content of Working Register: "+wReg.read());

        Backend.Befehle.Literal.literalCommands.ADDLW(0x0F, wReg, sReg);

        System.out.println("Content of Working Register: "+wReg.read());

        Backend.Befehle.Literal.literalCommands.SUBLW(0x0A, wReg, sReg);

        System.out.println("Content of Working Register: "+wReg.read());

        //Byte

        System.out.println("Data in Bank "+whichBank()+" at adress 0x10: "+data.readData(0x10, whichBank()));

        Backend.Befehle.Byteorientiert.byteCommands.MOVWF(0x10, wReg, sReg, data);

        System.out.println("Data in Bank "+whichBank()+" at adress 0x10: "+data.readData(0x10, whichBank()));

        Backend.Befehle.Byteorientiert.byteCommands.CLRW(wReg);

        System.out.println("Content of Working Register: "+wReg.read());
        
        Backend.Befehle.Byteorientiert.byteCommands.ADDWF(0x10,0,wReg,sReg,data);

        System.out.println("Content of Working Register: "+wReg.read());
        
        sReg.setRP0(false); //Switch to Bank 0
        Backend.Befehle.Byteorientiert.byteCommands.ADDWF(0x0C,0,wReg,sReg,data);

        System.out.println("Content of Working Register: "+wReg.read());
    }
 
    static int whichBank() {
        return sReg.getRP0() ? 1 : 0;
    }

}
