public class Stack {
    private Object[] stack;
    private int top; // Pointer to the top element

    // Capacity so resize() and allocationSize are not needed in order to maintain low computational complexity during pop & push
    // 'capacity' acts as maxLength
    public Stack(int capacity) {
        stack = new Object[capacity];
        top = -1;
    }

    public void push(Object element) {
        if (top == stack.length - 1) {
            // Stack is full
            throw new IllegalStateException("Stack is full. Cannot push.");
        }
        stack[++top] = element;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop!");
        }
        return stack[top--];
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek!");
        }
        return stack[top];
    }

    public int getLength() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void clear() {
        top = -1;
    }
}
