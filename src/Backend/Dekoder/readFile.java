package Backend.Dekoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {

    public static void main(String[] args) {
        
        ArrayList<String> instructions = new ArrayList<>();

        try(Scanner s = new Scanner(new File("src\\Backend\\Dekoder\\test.txt"))) {
            while(s.hasNextLine()) {
                instructions.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < instructions.size(); i++) {
            System.out.println(instructions.get(i));
            String[] bits = instructions.get(i).split(" ");

            int instruction = 0;

            int op;
            int address = 0;
            if(bits.length > 1) address = Integer.decode(bits[1]);
            int destination = 0;
            if(bits.length == 3) destination = Integer.decode(bits[2]);

            switch(bits[0]) {
                case "ADDWF":
                    op = 0b111<<8;
                    break;
                case "ANDWF":
                    op = 0b101<<8;
                    break;
                case "CLRF":
                    op = 0b11<<7;
                    break;
                case "CLRW":
                    op = 0b1<<8;
                    break;
                case "COMF":
                    op = 0b1001<<8;
                    break;
                case "DECF":
                    op = 0b11<<8;
                    break;
                case "DECFSZ":
                    op = 0b1011<<8;
                    break;
                case "INCF":
                    op = 0b101<<9;
                    break;
                case "INCFSZ":
                    op = 0b1111<<8;
                    break;
                case "IORWF":
                    op = 0b1<<10;
                    break;
                case "MOVF":
                    op = 0b1<<11;
                    break;
                case "MOVWF":
                    op = 0b1 << 7;
                    break;
                case "NOP":
                    op = 0;
                    break;
                case "RLF":
                    op = 0b1101<<8;
                    break;
                case "RRF":
                    op = 0b11<<10;
                    break;
                case "SUBWF":
                    op = 0b1<<9;
                    break;
                case "SWAPF":
                    op = 0b111<<9;
                    break;
                case "XORWF":
                    op = 0b11<<9;
                    break;
                default:
                    op = -1;
                    break;
            }

            if(bits.length == 2) {
                System.out.println("Operand: "+op+", Address: "+address);
            } else if(bits.length == 1) {
                System.out.println("Operand: "+op);
            } else {
                System.out.println("Operand: "+op+", Address: "+address+", Destination: "+(destination));
            }

            instruction = op + (address&0x7F) + (destination<<7);

            System.out.println("Instruction: "+instruction);

        }

        

    }

}
