// 2.1-3 线性查找
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for(int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        int index = linearSearch(array, v);
        System.out.print((-1 == index) ? null : index + 1);
    }

    static int linearSearch(int[] array, int v) {
        for(int i = 0; i < array.length; i++) {
            if(v == array[i]) {
                return i;
            }
        }
        return -1;
    }
}