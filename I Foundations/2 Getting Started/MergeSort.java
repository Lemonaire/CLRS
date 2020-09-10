import java.util.Scanner;

public class MergeSort {
    static final int max = 2147483647;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        mergeSort(array, 0, n - 1);
        for(int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

    }

    static void mergeSort(int[] array, int p, int r) {
        if(p < r) {
            int q = (int)Math.floor((p + r) / 2.0);
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    static void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for(int i = 1; i <= n1; i++) {
            L[i - 1] = array[p + i - 1];
        }
        for(int j = 1; j <= n2; j++) {
            R[j - 1] = array[q + j];
        }
        L[n1] = max;
        R[n2] = max;
        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++) {
            if(L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
        }
    }
}
