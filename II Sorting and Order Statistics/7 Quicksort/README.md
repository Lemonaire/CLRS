## 快速排序  

### 一般的快速排序  

思路：将数组分为两个部分，`array[start, part - 1]`和`array[part + 1, end]`，对于前者，其每一个元素都 `<=array[part]`，对于后者，其每一部分都`>=array[part]`，这样首先可以找到`array[part]`的正确位置，然后对于两个子数组，再进行递归排序，即可得到正确的排序结果。  

对于找到`part`的方法，使用`partition`完成。其本质是构造一个分割点`i`，对于循环变量`j`，从`start`递增到`end`的过程中，`i`始终小于`j`。在遍历过程中，只要找到一个小于等于`array[end]`的元素，就将`array[i+1]`与其交换，从而保证在`i`之前的所有元素都是小于等于`array[end]`的。最后将`array[end]`与`array[i+1]`交换，此时的`i+1`就是所需要的分割点`part`。  

时间复杂度：O(nlgn)  

循环不变式：在`partition`中每一次循环开始之前，对于`array[start, i]`，其值总小于等于`array[end]`；对于`array[i+1, j-1]`，其值总大于`array[end]`。  

代码：[Java](./QuickSort.java)  

注意点：递归要有终止条件；在`partition`循环时，循环变量应该从`start`到`end-1`，因为比较`array[end]`和`endVal`是没有意义的。  

### 随机快速排序  

思路：在快速排序之前，将数组中的随机一个元素与`array[end]`对换，使得划分能够尽量平均（接近`n/2`）  

代码：咕咕咕   