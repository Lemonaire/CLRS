## 线性时间排序  

### 计数排序  

思路：需要两个新的数列：`auxiliary`和`result`，作为辅助数组和结果输出。第一步给`auxiliary`赋初值为 0；第二步将`array`中的元素的值，作为`auxiliary`的下标，`auxiliary`中的对应元素的值`+1`；第三步对`auxiliary`的元素从前往后逐一累加，此时`auxiliary`的元素（记其下标为`index`，值为`value`）的意义是：在`array`中，`<=index`的元素共有`value`个；最后根据`auxiliary`的元素的下标和值，就可以将`array`中的元素重新排列进`result`，完成排序。  

时间复杂度：O(n)  

代码：[Java](./CountingSort.java)  

注意点：  

1. 考虑到`array`中的元素值可能会重复，所以在第四步排序时，要注意把已经排好的元素在`auxiliary`中的值`-1`，这样下次排到值相同的元素时，不会发生覆盖。  
2. 在第三个循环中，由于数组下标从`0`开始，`auxiliary`的值不能直接作为`result`的下标使用，而要`-1`。  
3. 由于数组下标的特殊性，这个排序方法只能局限在自然数排序。  