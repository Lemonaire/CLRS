import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        int[] result = countingSort(array, length, 100);
        for(int i = 0; i < length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static int[] countingSort(int[] array, int length, int max) {
        int[] result = new int[length];
        int[] auxiliary = new int[max + 1];
        for(int i = 0; i < length; i++) {
            result[i] = 0;
        }
        for(int i = 0; i < length; i++) {
            auxiliary[array[i]]++;
        }
        for(int i = 1; i <= max; i++) {
            auxiliary[i] += auxiliary[i - 1];
        }
        for(int i = length - 1; i >= 0; i--) {
            result[auxiliary[array[i]] - 1] = array[i];
            auxiliary[array[i]]--;
        }
        return result;
    }

}
