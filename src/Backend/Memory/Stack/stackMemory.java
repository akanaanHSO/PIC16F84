package Backend.Memory.Stack;
import java.util.Stack;

/**
 * Stack Memory is a stack that holds addresses.
 * The stack is 8 addresses long used to store return addresses for function calls.
 */
public class stackMemory {
    // Stack - Adresse 0-7
    private final Stack<Integer> stack = new Stack<Integer>();

    // pushes an address onto the stack
    public void push(int address) {
        if (stack.size() < 8) {
            stack.push(address & 0x3FFF);
        } else {
            System.out.println("stack overflow");
        }
    }

    // removes the top element of the stack and returns it
    public int pop() {
        if (!stack.empty()) {
            return stack.pop();
        } else {
            System.out.println("stack underflow");
            return 0;
        }
    }

    // prints the stack
    public void printStack() {
        System.out.println("Current stack: ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }

    // clears the stack
    public void clearStack() {
        stack.clear();
        System.out.println("stack cleared");
    }

    // returns the top element of the stack without removing it
    public int peek() {
        if (!stack.empty()) {
            return stack.peek();
        } else {
            System.out.println("stack underflow");
            return 0;
        }
    }
}
