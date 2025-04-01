package Backend.Memory.Stack;

/**
 * Stack Memory is a stack that holds return addresses for sub -program calls (CALL, RETURN, RETFIE, RETLW).
 * The stack is 8 addresses long (circular buffer behavior if overflow).
 */
public class stackMemory {
    // Stack - Adresse 0-7
    private final int[] stack = new int[8]; // 8 addresses
    private int stackPointer = 0; // 3 bits

    /**
     * puts a return address onto the stack
     */
    public void push(int address) {
        stack[stackPointer] = address & 0x1FFF; // mask to 13 bits
        stackPointer = (stackPointer + 1) % 8;
    }

    /**
     * removes the top element of the stack and returns it
     */
    public int pop() {
        stackPointer = (stackPointer - 1 + 8) % 8;
        return stack[stackPointer];
    }

    /**
     * prints the current stack (for debugging)
     */
    public void printStack() {
        System.out.println("Current stack: ");
        for (int i = 0; i < stack.length; i++) {
            System.out.printf("Stack[%d]: 0x%04X%n", i, stack[i]);
        }
    }

    /**
     * clears the stack (Reset)
     */
    public void clearStack() {
        for (int i = 0; i < stack.length; i++) {
            stack[i] = 0;
        }
        stackPointer = 0;
        System.out.println("stack cleared");
    }

    /**
     * returns the top element of the stack (without removing it)
     */
    public int peek() {
        int previousStackPointer = (stackPointer - 1 + 8) % 8;
        return stack[previousStackPointer];
    }
}
