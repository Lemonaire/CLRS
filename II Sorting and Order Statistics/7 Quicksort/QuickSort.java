import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        quickSort(array, 0, length - 1);
        for(int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if(start < end) {
            int part = partition(array, start, end);
            quickSort(array, start, part - 1);
            quickSort(array, part + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int i = start - 1;
        int endVal = array[end];
        for(int j = start; j < end; j++) {
            if(array[j] <= endVal) {
                i++;
                int t = array[j];
                array[j] = array[i];
                array[i] = t;
            }
        }
        array[end] = array[i + 1];
        array[i + 1] = endVal;
        return (i + 1);
    }
}
