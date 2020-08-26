// 2.1-4 二进制加法
import java.util.Scanner;

public class BinaryAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];
        for(int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < len; i++) {
            b[i] = sc.nextInt();
        }
        int[] c = binaryAdd(a, b, len);
        for(int i = 0; i <= len; i++) {
            System.out.print(c[i] + " ");
        }
    }

    static int[] binaryAdd(int[] a, int[] b, int len){
        int[] c = new int[len + 1];
        for(int i = 0; i <= len; i++) {
            c[i] = 0;
        }
        for(int i = len - 1; i >= 0; i--) {
            c[i + 1] += a[i] + b[i];
            if(2 <= c[i + 1]) {
                c[i] += 1;
                c[i + 1] -= 2;
            }
        }
        return c;
    }
}