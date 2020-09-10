#include<stdio.h>
#include<math.h>
#include<limits.h>

void mergeSort(int array[], int start, int end);
void merge(int array[], int start, int middle, int end);

int main() {
	int len;
	scanf("%d", &len);	// 读取需要排序的数组长度
	int array[len];

	// 读取需要排序的数组
	for(int i = 0; i < len; i++) {
		scanf("%d", &array[i]);
	}

	mergeSort(array, 0, len - 1);	// 排序

	// 打印排序完成的数组
	for(int i = 0; i < len; i++) {
		printf("%d ", array[i]);
	}

	return 0;
}

void mergeSort(int array[], int start, int end) {
	if(start < end) {
		int middle = floor((start + end) / 2.0);	// 取中点
		mergeSort(array, start, middle);
		mergeSort(array, middle + 1, end);
		merge(array, start, middle, end);
	}
}

void merge(int array[], int start, int middle, int end) {
	int len1 = middle - start + 1;
	int len2 = end - middle;
	int left[len1 + 1];
	int right[len2 + 1];

	// 在两个需要合并的数组最后加入 INT_MAX
	for(int i = 0; i < len1; i++) {
		left[i] = array[start + i];
	}
	for(int i = 0; i < len2; i++) {
		right[i] = array[middle + 1 + i];		
	}
	left[len1] = INT_MAX;
	right[len2] = INT_MAX;

	// 合并两个数组
	int j = 0, k = 0;
	for(int i = start; i < end + 1; i++) {
		if(left[j] > right[k]) {
			array[i] = right[k];
			k++;
		}
		else {
			array[i] = left[j];
			j++;
		}
	}
}
