#include<stdio.h>

void insertionSort(int array[], int len);

int main() {
	int len;
	scanf("%d", &len);	// 读取需要排序的数组长度
	int array[len];

	// 读取需要排序的数组
	for(int i = 0; i < len; i++) {
		scanf("%d", &array[i]);
	}

	insertionSort(array, len);	// 排序

	// 打印排序完成的数组
	for(int i = 0; i < len; i++) {
		printf("%d ", array[i]);
	}

	return 0;
}

void insertionSort(int array[], int len) {
	for(int i = 1; i < len; i++) {
		int key = array[i];
		int j = i - 1;
		// 依次后移更大的元素
		while(j >= 0 && array[j] > key) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = key;
	}
}
