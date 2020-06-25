# Week1

[数组、链表、跳表](https://u.geekbang.org/lesson/14?article=212203)

[栈、队列、优先队列、双端队列](https://u.geekbang.org/lesson/14?article=234450)

## 	一. 知识点总结

### 			1. 学习方法论

一：课前预习，课中思考，课后练习 

二：《outlier》（异类：不一样的成功启示录）:chunk it up deliberate切碎知识点 + practicing 练习 feedback 反馈 

三：chunk it up deliberate掌握基础知识点+串联起来（可以通过分类知识点然后组织在脑图上）

四：practicing 重复+专项练习，五毒神掌 

五：feedback 主动反馈（离线：GitHub，leetcode。在线：第一视角直播），被动反馈（有人指导） 

六：切题四件套（确定问题，解法多种可能性，写，测试），可用于面试或自己做题 

七：五毒神掌（一题五遍） 

​	1：五分钟出思路or看题解，拒绝死磕；思考不同解法优劣，背诵和默写

​	2：马上做一遍直至通过，尽量不看题解，最好多种方法都写写 

​	3：24小时后重做 

​	4：一周后重做 

​	5：面试前（1~2week）复盘

### 			2. 复杂度

* 常见复杂度排序O(1)、O(log n)、O(n)、O(nlog n)、O(n^2)、O(2^n)、O(n!)

-  递归常见复杂度：二分查找（O(log n)）、二叉树遍历（O(n)）、有序矩阵搜索（O(n)）、归并排序（O(nlog n)）

-  常见递归复杂度计算
   - 递推公式
   - 画出树状图，求和

### 			3. 数组、链表

* 数组：数组是一个线性表，他用一组**连续的内存空间**，来存储具有**相同类型**的数据。
  * ​	警惕越界
  * 插入删除要移动
* 链表：离散的空间，通过指针串联
  * 警惕内存泄漏（注意插入删除顺序）
  * 注意边界条件
    *  如果链表为空时，代码是否能正常工作？
    *  如果链表只包含一个结点时，代码是否能正常工作？
    *  如果链表只包含两个结点时，代码是否能正常工作？
    *  代码逻辑在处理头结点和尾结点的时候，是否能正常工作？

### 			4. 跳表与快速查找

数组    -->  二分查找    -->  限定有序

树      -->  平衡树      -->  限定树有序

链表    -->  跳表       -->  限定链表有序+跳表

跳表的基本原理是升维，增加索引维度，也可以说是用空间换时间

读 插入 删除  都是 log n

应用 redis 有序set  innerDB

### 			5. 习题知识点

找不到切题点的时候怎么办？

​    暴力解法解，不断优化暴力解

​    写出基本情况，然后找到最近重复子问题，之前解决的问题能不能拿来用？

​	解决问题的误区是死磕，加速的方法是升维

​	具有最近相关性的问题可以考虑用栈解决

​	具有先来后到问题的可以考虑用队列解决

​	滑动窗口题目想到用队列处理

## 	二. 本周习题

### 		2020.5.20

##### [146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/)

读题得解

* 数据结构为双链表。读à遍历，有则取出并插到head，并返回，O(n)；写à遍历，有则改之并插到head，无则插到head，O(n)

* 在上一个题解的基础上，增加Map,存放key和指针；读à查看Map中有无，有则取出并插到head，并返回，O(1)；写à查看Map中有无，有则改之插到head，无则插到head，O(n)

看题解：

​    一个有序集合类LinkedHashMap，几乎可以直接作为该题的解

需要注意的是头尾节点的处理，即上述链表边界条件。如果前驱节点为空？如果后继节点为空。或者直接使用带头带尾双链表



​		146. LRU缓存机制 代码完成。

### 		2020.5.21

##### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

读题得解

- 冒泡法：双层循环，将0一个一个移到尾部，O(n2)
  - 可通过，内层循环不执行交换，终止本次任务，上一次遇到0的位置，决定下一次的起始位置，来优化任务

- 拷贝法：准备同样大小的一个数组，将原数组的非零元素移动到该数组中，再将剩余部分补零。空间复杂度o(n)，时间复杂度O(n)

- 步长移动法：初始步长为0，遍历数组，遇0，+1,非零向右移动步长

看题解：

- 双指针法 ：a,b指针初始于起点，向后移动。遇到0，b向右移，a不变。非零，ab交换。B到尾部止

 

​                               

#### 146. LRU缓存机制 代码完成。

这次使用了带头尾双链表+hashMap做了一次，大概花了25分钟，带头尾节点通过增加这个哨兵真的能简化很多操作，很多那种边界条件就不用话很多心思考虑了。时间也优化了不少。

写的时候感觉优点陌生感，有钟之前作者这样写了吗的感觉，另外就是老是把精力花在了双链表上，反而忽视了Map的操作，导致很多问题。还是要重视细节啊。

 

 

##### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

再次完成该代码，主要用了步长移动法和指针法，两种方法的复杂度都差不多，但是细化的话发现步长法还是要多一些，步长法在为0的时候仍有操作。

 

##### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

读题得解：

只想到了暴力的解

看题解：

双指针法：

- 要移动两边的话都可以考虑双指针法

看题解，理解：

左右两个指针，得到盛水面积，面积取决于短的指针

若想增大面积，则只能向内移动短的指针

​    宽度减小，移动长边：更长，高度取决于小边，高度不变，宽度减小，面积减小；更短，高度减小，宽度减小，面积减小。

​    移动短边，更长，高度变长，宽度减小，面积可能变大;

​    所以当前状态为短边能达到的最大容积（边长最长，高度为自身），移动短边。即永久排除短边其他容积可能性。

最后两指针相遇，所有最大容积的可能性就得到了

 

[通过搜索空间的证明](https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/)

##### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

读题得解：

- 递归：每次f(n)=f(n-1)+f(n-2)  f(-1) = 0 f(0)=1
  - 做完发现这是斐波拉契数列，递归会有重复计算问题，可用记忆递归

- 两个固定值没想好这么搞，最后是面向测试用例出的结果这样可不行

读题得解

- 动态规划/斐波拉契：通过上一次的结果，得到这一次的结果，向上走 爬1，2知道，则3知道，2，3知道则4知道

- Binets方法

- 斐波拉契公式：

 

### 		2020.5.24

##### [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

读题得解：

- hash法： 直接会想到使用set求解 时间复杂度O(n),时间复杂度o(n)

只需要将重复的元素直接移到数组尾部（但是同时数组长度也要减一，移过来的元素也要检测），需要注意的是，判题程序只检测数组的0~返回值长度部分，并且需要有序，所以这种方法的结果需要对nums区间排序。

- 排序法：对无序数组排序重复元素相邻。时间复杂度O(nlogn),时间复杂度o(n)

看题解：

才发现原来已经 是排序的数组了 org

- 双指针法：移动零的方法求解，一个指针指向无重复项，一个指针指向新的元素，两个指针元素不一样，则无重复项+1，两个指针移动；不一样则只有新元素指针向前移动

- 步长法：参考移动零，记录与无重复部分的距离，遇到重复元素，距离+1，无重复元素，将其添加到无重复部分
  - 上述两种方法本质上都一样
  - 比较可以比较之前的无重复元素，也可以和自己前面的元素比较

##### [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

读题得解：

- 另一个数组：index +3 %len

- 链表法：用链表然后移动节点，再转换成数组

- 辅助队列（缓存）：构建一个长度为k+1的队列，遍历数组，先入队，满队则出队，到当前index。最后从数组首部开始出队。O(n),o(k)

看题解

- 三次反转：全部反转，反转前k，反转后面n-k，着实巧妙

- 环状替代：保留当前index值，用保留的值替换index+k的值，再用这次保留的交换index+k+k的值，直到替换到起始位置。注意退出条件 ，避免循环替代

##### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

读题得解：

- 返回其中一个链表：以头节点小的为主链表，另一节点在主链表上修改；time O(m+n) space O(1)

看题解

- 递归：每次递归将小的节点添加到主链表上

- 迭代：增加哨兵节点可以免去选取头节点的烦恼

##### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

读题得解

首先肯定要避免插入元素带来的大量移动

- 另一个数组：先将nums1拷贝到另一个数组（或者尾部），再合并两个数组到nums1  

看题解：

- 尾部双指针：利用尾部空间，从尾部开始插入较大的元素，只需要考虑nums2未查完情况，因为nums1未插完，还是再nums1中，不用管；

##### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

读题得解

- 暴力双循环： 注意j = i+1

- 辅助hashmap：将元素先扫一遍，放入hashMap，再遍历元素，看target – a 在不在map中

看题解

- 一次hashMap：target – a只在扫过的地方找，这个和两遍是一样的，因为如果是该元素和后面一个元素组合成解的话，之后扫到后面这个元素的时候也可以得到这个解

##### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

- 暴力法：转化成数字，+1，转化成数组

- 逆向遍历法：从尾部开始遍历，元素为9，->continue；else +1 break,需要注意的是位数增加的数字

##### [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

看题解：

看了题解也不是很懂，不死磕了先记下来下次再看一遍。

- 动态规划

- 双指针

- 栈

## 	三. 源码分析

### 1. Queue

一个接口

有如下方法

 

| 为空或者空间不够抛出异常 | 不抛出异常，而是返回null |
| ------------------------ | ------------------------ |
| boolean add(E e);        | boolean offer(E e);      |
| E remove();              | E poll();                |
| E element();             | E peek();                |
|                          |                          |

有很多实现

### 2. PriorityQueue

底层的数据结构是用堆做的，更具体的 下周再细看

## 四. 日程

<center>Week1</center>

| 题目                                                         | first (plan / done) | second (plan / done) | third(plan / done) | fourth(plan / done) | fifth (plan / done) | 备注                                                         |
| ------------------------------------------------------------ | ------------------- | -------------------- | ------------------ | ------------------- | ------------------- | ------------------------------------------------------------ |
| [Week1](#Week1)                                              | Lesson3             |                      |                    |                     |                     |                                                              |
| [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/) | 20.5.21 / 20.5.21   | 20.5.21 / 20.5.21    | 20.5.22 /          |                     |                     | [实战](#[11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)) |
| [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/) |                     |                      |                    |                     |                     | [实战&习题](#[283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)) |
| [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) |                     |                      |                    |                     |                     | [实战](#[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)) |
| [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)     |                     |                      |                    |                     |                     | [实战&习题](#[1. 两数之和](https://leetcode-cn.com/problems/two-sum/)) |
| [15. 三数之和](https://leetcode-cn.com/problems/3sum/)       |                     |                      |                    |                     |                     | [实战](#)                                                    |
| [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/) |                     |                      |                    |                     |                     | [实战](#)                                                    |
| [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/) |                     |                      |                    |                     |                     | [实战](#)                                                    |
| [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/) |                     |                      |                    |                     |                     | [实战](#)                                                    |
| [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) |                     |                      |                    |                     |                     | [实战](#)                                                    |
| [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/) |                     |                      |                    |                     |                     | [实战](#)                                                    |
| [Week1](#Week1)                                              | Lesson4             |                      |                    |                     |                     |                                                              |
| [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/) |                     |                      |                    |                     |                     | [预习](#[20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)) |
| [155. 最小栈](https://leetcode-cn.com/problems/min-stack/)   |                     |                      |                    |                     |                     | [预习](#[155. 最小栈](https://leetcode-cn.com/problems/min-stack/)) |
| [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/) |                     |                      |                    |                     |                     | [实战](#[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)) |
| [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/) |                     |                      |                    |                     |                     | [实战](#)                                                    |
| [641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/) |                     |                      |                    |                     |                     | [习题](#)                                                    |
| [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/) |                     |                      |                    |                     |                     | [习题](#[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)) |
| [Week1](#Week1)                                              | Homework            |                      |                    |                     |                     |                                                              |
| [66. 加一](https://leetcode-cn.com/problems/plus-one/)       |                     |                      |                    |                     |                     | [习题](#[66. 加一](https://leetcode-cn.com/problems/plus-one/)) |
| [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/) |                     |                      |                    |                     |                     | [习题](#[88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)) |
| [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/) |                     |                      |                    |                     |                     | [习题](#[21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)) |
| [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/) |                     |                      |                    |                     |                     | [习题](#)                                                    |
| [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/) |                     |                      |                    |                     |                     | [习题](#[189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)) |
| [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) |                     |                      |                    |                     |                     | [习题](#[26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)) |

