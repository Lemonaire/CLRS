// 2.1-2 非升序的插入排序
import java.util.Scanner;

public class InsertionSort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for(int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        insertionSort(array, len);
        for(int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static void insertionSort(int[] array, int len) {
        for(int i = 1; i < len; i++) {
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}