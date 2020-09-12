// 4.1 最大子数组问题
/*
    测试数据
    16
    13 -3 -25 20 -3 -16 -23 18 20 -7 12 -5 -22 15 -4 7
    结果：7 10 43
 */
import java.util.Scanner;

public class MaxSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for(int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
//        int[] result = findMaxSubarray_recursive(array, 0, len - 1);
        int[] result = findMaxSubarray_bruteForce(array);
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

    static int[] findMaxSubarray_recursive(int[] array, int start, int end) {
        if(start == end) {
            return new int[] {start, end, array[start]};
        }
        else {
            int mid = (start + end) / 2;
            int[] leftMax = findMaxSubarray_recursive(array, start, mid);
            int[] rightMax = findMaxSubarray_recursive(array, mid + 1, end);
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

    static int[] findMaxSubarray_bruteForce(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int leftIndex = -1;
        int rightIndex = -1;
        for(int i = 0; i < array.length; i++) {
            int j = i;
            int sum = 0;
            while(j < array.length) {
                sum += array[j];
                if(sum > maxSum) {
                    maxSum = sum;
                    leftIndex = i;
                    rightIndex = j;
                }
                j++;
            }
        }
        return new int[] {leftIndex, rightIndex, maxSum};
    }
}
