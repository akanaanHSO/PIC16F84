package Backend.Memory.Stack;

public class stackMemory {
    // Stack - Adresse 0-7
    int stack[] = new int[8];

    public void push(int data) {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == 0) {
                stack[i] = data;
                break;
            }
        }
    }

    public int pop() {
        int data = 0;
        for (int i = stack.length - 1; i >= 0; i--) {
            if (stack[i] != 0) {
                data = stack[i];
                stack[i] = 0;
                break;
            }
        }
        return data;
    }

    public void printStack() {
        for (int i = 0; i < stack.length; i++) {
            System.out.println("Stack[" + i + "] = " + stack[i]);
        }
    }

    public void clearStack() {
        for (int i = 0; i < stack.length; i++) {
            stack[i] = 0;
        }
    }

    public int getStackLength() {
        return stack.length;
    }

    public int getStackValue(int address) {
        return stack[address];
    }

    public void setStackValue(int address, int data) {
        stack[address] = data;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int[] getStack() {
        return stack;
    }
}
