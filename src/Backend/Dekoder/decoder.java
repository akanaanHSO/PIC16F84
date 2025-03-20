package Backend.Dekoder;

public class decoder {
    public int[] decode(int instruction) {
        int length = 0;
        int mask1 = 0b11100000000000;
        int mask2 = 0b11111100000000;
        int mask3 = 0b11111111110000;
        int mask4 = 0b11111111111111;


        int[] decodedInstruction = new int[4];
        decodedInstruction[0] = instruction >> 6 & 0b11;
        decodedInstruction[1] = instruction >> 4 & 0b11;
        decodedInstruction[2] = instruction >> 2 & 0b11;
        decodedInstruction[3] = instruction & 0b11;
        return decodedInstruction;
    }


}
