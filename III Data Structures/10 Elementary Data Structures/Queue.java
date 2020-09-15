public class Queue {
    private int head;
    private int tail;
    private int max;
    private int[] queue;

    Queue() {
        this(100);
    }

    Queue(int max) {
        this.max = max;
        queue = new int[max];
        head = 0;
        tail = 0;
    }

    public void enqueue(int x) {
        if(isFull()) {
            System.out.println("queue overflow");
        }
        else if(tail == max - 1) {
            queue[tail] = x;
            tail = 0;
        }
        else {
            queue[tail] = x;
            tail++;
        }
    }

    public void dequeue() {
        if(isEmpty()) {
            System.out.println("queue underflow");
        }
        else if(head == max - 1) {
            head = 0;
        }
        else {
            head++;
        }
    }

    public boolean isEmpty() {
        if(head == tail) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull() {
        if(head == tail + 1 || (tail == max - 1 && head == 0)) {
            return true;
        }
        else {
            return false;
        }
    }
}
