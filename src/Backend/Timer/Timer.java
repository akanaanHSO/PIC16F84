package Backend.Timer;

/**
 * Timer class is used to manage the timer functionality of the microcontroller.
 */
public class Timer {
    private int counter; // 8 bits Timer0
    private int prescaler; // Prescaler value (2, 4, 8, 16, 32, 64, 128, 256)
    private int prescalerCounter; // counting clock for prescaler
    private boolean prescalerAssignedToTimer; // true = prescaler is assigned to timer, false = Watchdog

    private boolean t0ifFlag; // Interrupt-Flag (if TMR0 overflowed)

    public Timer () {
        this.counter = 0;
        this.prescaler = 0;
        this.prescalerCounter = 0;
        this.prescalerAssignedToTimer = true; // default
        this.t0ifFlag = false;
    }

    public void assignPrescalerToTimer(boolean assigned) {
        this.prescalerAssignedToTimer = assigned;
    }

    public void setPrescaler (int value) {
        if (value == 1 || value == 2 || value == 4 || value == 8 || value == 16 || value == 32 || value == 64 || value == 128 || value == 256) {
            this.prescaler = value;
        } else {
            System.out.println("Invalid prescaler value. Prescaler must be 1, 2, 4, 8, 16, 32, 64, 128 or 256.");
        }
    }

    public void reset() {
        this.counter = 0;
        this.prescalerCounter = 0;
        this.t0ifFlag = false;
    }

    public void write(int value) {
        this.counter = value & 0xFF; // only 8 bits are used
    }

    public int read() {
        return this.counter;
    }

    public boolean isT0IFSet() {
        return t0ifFlag;
    }

    public void clearT0IF() {
        t0ifFlag = false;
    }

    public void tick() {
        if (!prescalerAssignedToTimer || prescaler == 1) {
            increment();
            return; // Prescaler is not assigned to timer
        }
        prescalerCounter++;
        if (prescalerCounter >= prescaler) {
            increment();
            prescalerCounter = 0;
        }
    }

    private void increment() {
        counter++;
        if (counter > 255) {
            counter = 0;
            t0ifFlag = true; // Set the interrupt flag if overflow occurs
        }
    }
}
