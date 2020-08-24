public class RestoreString {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = new int[]{4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s, indices));
    }

    public static String restoreString(String s, int[] indices) {
        char[] charS = s.toCharArray();
        mergeSort(indices, charS, 0, charS.length - 1);
        return String.valueOf(charS);
    }

    public static void merge(int[] array, char[] charS, int start, int middle, int end) {
        int len1 = middle - start + 1;
        int len2 = end - middle;
        int[] left = new int[len1 + 1];
        int[] right = new int[len2 + 1];
        char[] charLeft = new char[len1];
        char[] charRight = new char[len2];
        
        for(int i = 0; i < len1; i++) {
            left[i] = array[start + i];
            charLeft[i] = charS[start + i];
        }
        for(int i = 0; i < len2; i++) {
            right[i] = array[middle + 1 + i];
            charRight[i] = charS[middle + 1 +i];
        }
        left[len1] = Integer.MAX_VALUE;
        right[len2] = Integer.MAX_VALUE;

        int k = 0, j = 0;
        for(int i = start; i <= end; i++) {
            if(left[k] < right[j]) {
                array[i] = left[k];
                charS[i] = charLeft[k];
                k++;
            }
            else {
                array[i] = right[j];
                charS[i] = charRight[j];
                j++;
            }
        }
    }

    public static void mergeSort(int[] array, char[] charS, int start, int end) {
        if(start < end) {
            int middle = (int)Math.floor((start + end) / 2.0);
            mergeSort(array, charS, start, middle);
            mergeSort(array, charS, middle + 1, end);
            merge(array, charS, start, middle, end);
        }
    }
}