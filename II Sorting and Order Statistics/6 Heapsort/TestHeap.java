import java.util.Scanner;

public class TestHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        heap.heapSort(array);
        for(int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
