// 10.1-1
public class TwoStacks {
    private int top1;
    private int top2;
    private int max;
    private int[] stack;

    TwoStacks() {
        this(100);
    }

    TwoStacks(int max) {
        this.max = max;
        stack = new int[max];
        top1 = 0;
        top2 = max - 1;
    }

    public void push1(int x) {
        if(top1 == max - 1 || top1 == top2 - 1) {
            System.out.println("stack overflow");
        }
        else {
            top1++;
            stack[top1] = x;
        }
    }

    public void push2(int x) {
        if(top2 == 0 || top2 == top1 + 1) {
            System.out.println("stack overflow");
        }
        else {
            top2--;
            stack[top2] = x;
        }
    }

    public void pop1() {
        if(isEmpty1()) {
            System.out.println("stack underflow");
        }
        else {
            top1--;
        }
    }

    public void pop2() {
        if(isEmpty2()) {
            System.out.println("stack underflow");
        }
        else {
            top2++;
        }
    }

    public boolean isEmpty1() {
        if(top1 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEmpty2() {
        if(top2 == max - 1) {
            return true;
        }
        else {
            return false;
        }
    }

}
