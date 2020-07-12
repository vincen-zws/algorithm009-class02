# Week8



## 一. 知识点

### 1. 位运算

1. 移动 

   左移 ： x << 2  左移两位 0011 --> 1100

   右移 ：  x>> 1  右移一位  1100 --> 0110

   无符号右移 ： x>>> 2 连带符号位一起右移两位

   没有无符号左移，因为会乱符号位常变

   运算符：& (按位与) 、 | (按位或) 、 ~ (按位非) 、 ^ (按位异或 同1异0)

2. XOR 异或 tips : 

   x^0 = x	x^1s = ~x (1s = ~0) 	x^(~x) = 1s 	x^x = 0 	

   交换律：a^b = c 	c^b = a 	a^c = b

   结合律：a^b^c = (a^b)^c = a^(b^c)

3. 指定位置的位运算

   将x最右边的n位清零：x&(~0<<n)；

   获取x第n位值（0/1）：(x>>n)&1

   获取x第n位的幂值：x&(1<<n)

   仅将x第n位置为1：x|(1<<n)

   仅将x第n位置为0：x|(~(1<<n))

   将x最高位至第n位（含）清零：x&((1<<n)-1)

   将第n位至第0位（含）清零：x&((~0<<n+1))

   x&(~(~0<<n))

   x&((~0<<n+1))

4. 实战常用

   - 判断奇偶：x%2==0  --> x&1 == 0

   ​					x%2==1 --> x&1 == 1

   - 乘/除2：x/2  --> x>>1     x*2  -->  x<<1（乘法避免溢出）

   - 清零最低位的1：x=x&(x-1)      100011000 -->  100010000
   - 得到最低位的1：x&-x
   - x&~x = 0

### 2. 布隆过滤器

- 在/不在：如果一个元素不在布隆过滤器里面 则一定不在，如果在，则可能在

一个bit数组+多个hash算法，通过将一个key 通过多个hash算法到bit数组的不同位置，插入则全置为1，查询则只要有0则不在，全1可能在，不可删除元素；

- 常见用处：可以作为数据库最外层判别：不在不找，在就找（可能找不到）

### 3. LRUCache

最近最少使用缓存策略

get：取出后放到最前面，再返回

put：如果cache已满，删除最后面的元素后，再放入最前面，没满直接放最前

### 4. 排序算法

1. 初级排序：选择、插入、冒泡

   - 选择：从未排序区间选取最小值，置于已排序区间末尾，初始未排序区间[0,n），初始已排序（0，0）

     模板：

     ```java
         public static void selectionSort(int[] a, int n) {
             if (n <= 1) return;
     
             for (int i = 0; i < n - 1; ++i) {
                 // 查找最小值
                 int minIndex = i;
                 for (int j = i + 1; j < n; ++j) {
                     if (a[j] < a[minIndex]) {
                         minIndex = j;
                     }
                 }
     
                 // 交换
                 int tmp = a[i];
                 a[i] = a[minIndex];
                 a[minIndex] = tmp;
             }
         }
     ```

   - 冒泡：双层循环，相邻元素逆序则交换

     模板：

     ```java
         public static void bubbleSort(int[] a, int n) {
             if (n <= 1) return;
     
             for (int i = 0; i < n; ++i) {
                 // 提前退出标志位
                 boolean flag = false;
                 for (int j = 0; j < n - i - 1; ++j) {
                     if (a[j] > a[j + 1]) { // 交换
                         int tmp = a[j];
                         a[j] = a[j + 1];
                         a[j + 1] = tmp;
                         // 此次冒泡有数据交换
                         flag = true;
                     }
                 }
                 if (!flag) break;  // 没有数据交换，提前退出
             }
         }
     ```

   - 插入：遍历未排序区间，对每个元素，从后向前遍历已排序区间，找到相应位置并插入。

     模板：

     ```java
         public static void insertionSort(int[] a, int n) {
             if (n <= 1) return;
     
             for (int i = 1; i < n; ++i) {
                 int value = a[i];
                 int j = i - 1;
                 // 查找要插入的位置并移动数据
                 for (; j >= 0; --j) {
                     if (a[j] <= value) break;
                     a[j+1] = a[j];
                 }
                 a[j + 1] = value;
             }
         }
     ```

     插入排序要优于冒泡，虽然他们时间复杂度表示一致，但是冒泡排序对一个逆序数对要做三次赋值操作，但是插入排序只有最后才做三次其他只向后移动一位，只用操作一次

2. 高级排序：快速、归并、堆排

   - 快速排序：选取一个标杆，然后将区间内的序列大于标杆的放在标杆右边，小于标杆的放在标杆左边。然后逐层对标杆左子区间和右子区间执行同样的操作。

     模板：

     ```java
     public static void quickSort(int[] array, int begin, int end) {
         if (end <= begin) return;
         int pivot = partition(array, begin, end);
         quickSort(array, begin, pivot - 1);
         quickSort(array, pivot + 1, end);
     }
     public static int partition(int[] a, int begin, int end) {
         // pivot: 标杆位置，counter: 小于pivot的元素的个数 ；小于pivot 和 未遍历与大于pivot区间的界限
         int pivot = end, counter = begin;
         for (int i = begin; i < end; i++) {
             if (a[i] < a[pivot]) {
                 int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                 counter++;
             }
         }
         int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
         return counter;
     }
     ```

   - 归并排序：

     将一个序列分为两部分，然后将两部分分别排序，再将排好序的两部分分别合并在一起

     模板

     ```java
     public static void mergeSort(int[] a, int left, int right) {
         if (right <= left) return;
         int mid = left + ((right - left) >> 1); // (left + right) / 2
     
         mergeSort(a, left, mid);
         mergeSort(a, mid + 1, right);
         merge(a, left, mid, right);
     }
     
     public static void merge(int[] arr, int left, int mid, int right) {
             int[] temp = new int[right - left + 1]; // 中间数组
             int i = left, j = mid + 1, k = 0;
     
             while (i <= mid && j <= right) {
                 temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
             }
     
             while (i <= mid)   temp[k++] = arr[i++];
             while (j <= right) temp[k++] = arr[j++];
     
             for (int p = 0; p < temp.length; p++) {
                 arr[left + p] = temp[p];
             }
             // 也可以用 System.arraycopy(a, start1, b, start2, length)
         }
     ```

   - 堆排序：

     先建堆，再依次取出堆顶元素

     ```java
     static void heapify(int[] array, int length, int i) {
         int left = 2 * i + 1, right = 2 * i + 2；
         int largest = i;
         if (left < length && array[left] > array[largest]) {
             largest = left;
         }
         if (right < length && array[right] > array[largest]) {
             largest = right;
         }
         if (largest != i) {
             int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
             heapify(array, length, largest);
         }
     }
     public static void heapSort(int[] array) {
         if (array.length == 0) return;
         int length = array.length;
         for (int i = length / 2-1; i >= 0; i--) 
             heapify(array, length, i);
         for (int i = length - 1; i >= 0; i--) {
             int temp = array[0]; array[0] = array[i]; array[i] = temp;
             heapify(array, i, 0);
         }
     }
     ```

     

     

     

   

| 排序方法    | 时间复杂度（平均） | 时间复杂度（最坏） | 时间复杂度（最好） | 空间复杂度  | 稳定性 |
| ----------- | ------------------ | ------------------ | ------------------ | ----------- | ------ |
| 插入排序    | O( n^2 )           | O( n^2 )           | O(n)               | O(1)        | 稳定   |
| 希尔排序    | O( n^1.3 )         | O( n^2 )           | O(n)               | O(1)        | 不稳定 |
| 选择排序    | O( n^2 )           | O( n^2 )           | O( n^2 )           | O(1)        | 不稳定 |
| 冒泡排序    | O( n^2 )           | O( n^2 )           | O( n )             | O(1)        | 稳定   |
| O( n logn ) |                    |                    |                    |             |        |
| 快速排序    | O( n logn )        | O( n^2)            | O( n logn )        | O( n logn ) | 不稳定 |
| 归并排序    | O( n logn )        | O( n logn )        | O( n logn )        | O( n )      | 稳定   |
| 堆排序      | O( n logn )        | O( n logn )        | O( n logn )        | O(1)        | 不稳定 |
| 特殊        |                    |                    |                    |             |        |
| 计数排序    | O( n + k )         | O( n + k )         | O( n + k )         | O( n + k )  | 稳定   |
| 桶排序      | O( n + k )         | O( n^2)            | O( n )             | O( n + k )  | 稳定   |
| 基数排序    | O( n * k )         | O( n * k )         | O( n + k )         | O( n + k )  | 稳定   |



## 二. 习题

## 三. 日程

<center>Week8</center>



| 题目                                                         | first (plan / done)   | second (plan / done)  | third(plan / done) | fourth(plan / done) | fifth (plan / done) | 备注 |
| ------------------------------------------------------------ | --------------------- | --------------------- | ------------------ | ------------------- | ------------------- | ---- |
| [Week8](#Week8)                                              | Lesson16              |                       |                    |                     |                     |      |
| [191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/) | 2020.7.10 / 2020.7.10 | 2020.7.10 / 2020.7.10 |                    |                     |                     |      |
| [231. 2的幂](https://leetcode-cn.com/problems/power-of-two/) | 2020.7.10 / 2020.7.10 | 2020.7.10 / 2020.7.10 |                    |                     |                     |      |
| [190. 颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/) |                       |                       |                    |                     |                     |      |
| [51. N皇后](https://leetcode-cn.com/problems/n-queens/)      |                       |                       |                    |                     |                     |      |
| [52. N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/) |                       |                       |                    |                     |                     |      |
| [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/) |                       |                       |                    |                     |                     |      |
| [Week8](#Week8)                                              | Lesson17              |                       |                    |                     |                     |      |
| [146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/) |                       |                       |                    |                     |                     |      |
| [Week8](#Week8)                                              | Lesson18              |                       |                    |                     |                     |      |
| 6个排序算法                                                  | 2020.7.8 / 2020.7.8   | 2020.7.8 / 2020.7.8   | 2020.7.9 /         | 2020.7.15 /         |                     |      |
| [1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/) |                       |                       |                    |                     |                     |      |
| [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/) |                       |                       |                    |                     |                     |      |
| [1244.力扣排行榜](https://leetcode-cn.com/problems/design-a-leaderboard/) |                       |                       |                    |                     |                     |      |
| [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/) |                       |                       |                    |                     |                     |      |
| [493. 翻转对](https://leetcode-cn.com/problems/reverse-pairs/) |                       |                       |                    |                     |                     |      |
|                                                              |                       |                       |                    |                     |                     |      |
|                                                              |                       |                       |                    |                     |                     |      |
|                                                              |                       |                       |                    |                     |                     |      |
|                                                              |                       |                       |                    |                     |                     |      |
|                                                              |                       |                       |                    |                     |                     |      |