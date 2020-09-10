// 4.1 最大子数组问题
import java.util.Scanner;

public class MaxSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for(int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        int[] result = findMaxSubarray(array, 0, len - 1);
        for(int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }
    static int[] findMaxCrossingSubarray(int[] array, int start, int mid, int end) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftIndex = -1;
        for(int i = mid; i >= start; i--) {
            sum += array[i];
            if(sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int rightIndex = -1;
        for(int i = mid + 1; i <= end; i++) {
            sum += array[i];
            if(sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }

        return new int[] {leftIndex, rightIndex, leftSum + rightSum};
    }

    static int[] findMaxSubarray(int[] array, int start, int end) {
        if(start == end) {
            return new int[] {start, end, array[start]};
        }
        else {
            int mid = (start + end) / 2;
            int[] leftMax = findMaxSubarray(array, start, mid);
            int[] rightMax = findMaxSubarray(array, mid + 1, end);
            int[] midMax = findMaxCrossingSubarray(array, start, mid, end);
            if(leftMax[2] > rightMax[2] && leftMax[2] > midMax[2]) {
                return leftMax;
            }
            else if(rightMax[2] > leftMax[2] && rightMax[2] > midMax[2]) {
                return rightMax;
            }
            else {
                return midMax;
            }
        }
    }
}
