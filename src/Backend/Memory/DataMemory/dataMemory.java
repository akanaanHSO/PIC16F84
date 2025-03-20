package Backend.Memory.DataMemory;

public class dataMemory {
    // RAM
    int RAM[] = new int[2];
    //Adressspiegelung
    int bank0[] = new int[128]; //12-79
    int bank1[] = new int[128]; //140-207

    public void writeData(int address, int data) {
        dataMem[address] = data;
    }

    public int readData(int address) {
        return dataMem[address];
    }
}
