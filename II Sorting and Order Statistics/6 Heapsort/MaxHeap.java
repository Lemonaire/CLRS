public class MaxHeap {
    private int[] array;
    private int length, heapSize;

    public void buildMaxHeap(int[] array) {
        this.array = array;
        heapSize = array.length;
        length = heapSize;
        for(int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    public int getParent(int i) {
        return (i - 1)/2;
    }

    public int getLeftChild(int i) {
        return 2 * i + 1;
    }

    public int getRightChild(int i) {
        return (2 * (i + 1));
    }

    public void maxHeapify(int[] array, int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int max;
        if(left < heapSize && array[left] > array[i]) {
            max = left;
        }
        else {
            max = i;
        }
        if(right < heapSize && array[right] > array[max]) {
            max = right;
        }
        if(max != i) {
            int t = array[max];
            array[max] = array[i];
            array[i] = t;
            maxHeapify(array, max);
        }
    }

    public void heapSort(int[] array) {
        buildMaxHeap(array);
        for(int i = array.length - 1; i > 0; i--) {
            int t = array[i];
            array[i] = array[0];
            array[0] = t;
            heapSize--;
            maxHeapify(array, 0);
        }
    }
}
