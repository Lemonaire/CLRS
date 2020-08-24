import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for(int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        insertionSort(array);
        for(int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void insertionSort(int[] array) {
        int len = array.length;
        for(int j = 1; j < len; j++) {
            int key = array[j];
            int i = j - 1;
            while(i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}
