public class Stack {
    private int top = 0;
    private int max;
    private int[] stack;

    Stack() {
        this(100);
    }

    Stack(int max) {
        this.max = max;
        stack = new int[max];
    }

    public void push(int x) {
        if(top == max - 1) {
            System.out.println("stack overflow");
        }
        else {
            top++;
            stack[top] = x;
        }
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("stack underflow");
        }
        else {
            top--;
        }
    }

    public boolean isEmpty() {
        if(top == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
