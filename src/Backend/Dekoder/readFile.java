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
            System.out.println("Operand: "+bits[0]+", Other Stuff: "+Integer.decode(bits[1]));
        }

        

    }

}
