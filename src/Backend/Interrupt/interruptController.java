package Backend.Interrupt;

/**
 * Interrupt Controller is a class that is used to handle the interrupts in the
 * microcontroller. It is responsible for enabling and disabling the interrupts,
 * as well as handling the interrupt requests.
 * GIE
 */
public class interruptController {
    private boolean interruptEnabled = false; // Flag to check if interrupts are enabled
    private boolean interruptRequest = false; // Flag to check if there is an interrupt request
    private int[] interruptFlags = new int[8];

    /**
     * Method to enable interrupts.
     */
    public void enableInterrupts() {
        interruptEnabled = true;
    }

    /**
     * Method to disable interrupts.
     */
    public void disableInterrupts() {
        interruptEnabled = false;
    }

    /**
     * Method to check if interrupts are enabled.
     *
     * @return true if interrupts are enabled, false otherwise
     */
    public boolean areInterruptsEnabled() {
        return interruptEnabled;
    }

    /**
     * Method to set the interrupt request flag.
     */
    public void setInterruptRequest() {
        interruptRequest = true;
    }

    /**
     * Method to clear the interrupt request flag.
     */
    public void clearInterruptRequest() {
        interruptRequest = false;
    }

    /**
     * Method to check if there is an interrupt request.
     *
     * @return true if there is an interrupt request, false otherwise
     */
    public boolean isInterruptRequested() {
        return interruptRequest;
    }
}
