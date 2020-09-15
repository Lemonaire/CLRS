public class MaxHeap {
    private int[] array;
    private int length, heapSize;

    MaxHeap(int[] array) {
        this.array = array;
        heapSize = array.length;
        length = heapSize;
        for(int i = heapSize / 2; i >= 0; i++) {
            maxHeapify(array, i);
        }
    }

    public int getParent(int i) {
        return i/2;
    }

    public int getLeftChild(int i) {
        return 2 * i;
    }

    public int getRightChild(int i) {
        return (2 * i + 1);
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
        if(right > heapSize && array[right] > array[max]) {
            max = right;
        }
        if(max != i) {
            int t = array[max];
            array[max] = array[i];
            array[i] = t;
            maxHeapify(array, max);
        }
    }
}
