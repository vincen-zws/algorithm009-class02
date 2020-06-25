[哈希表、映射、集合](https://u.geekbang.org/lesson/14?article=238676)

[树、二叉树、二叉搜索树](https://u.geekbang.org/lesson/14?article=239009)

[堆和二叉堆、图](https://u.geekbang.org/lesson/14?article=239044)

## 一. 知识点

1. hash

2. 树

   树和图区别，树没有环

   - 遍历，前序（根左右），中序（左根右），后序（左右根）。递归，最简单。循环，深度用栈，层序用队列
   - 二叉搜索树/二叉排序树：空或 **所有**左节点 < 根  < **所有**右节点。
     - 用中序遍历的话就是升序排列
     - 查询、插入:O(logn)
     - 删除：用左子树的最右节点，或者右子树的最左节点代替，在中序遍历中相邻

3. 图

   Graph(V,E)

   V:点

   1. 度：入度和出度
   2. 点与点：联通与否：直接，间接

   E:边

   1. 有向和无向
   2. 权重：边长

   邻接矩阵，邻接表

4. 堆

   堆的实现有很多种，二叉堆并不是最优解只是实现容易，最好的应该是严格斐波拉契堆，只是较为复杂

   二叉堆：完全二叉树，靠左；root=0 , lchild = 2i+1 ，rchild = 2i+2 , floor=(i-1)/2 

    插入尾部，上浮；删除，换尾，下沉

   在java priorityQueue中实现，默认最小堆，可通过实例对象时传入Comparator改变比较方式从而实现最大堆

状态表示：状态转移，边界情况；

## 二. 本周习题

### 2020.5.25

先开始复习，宁愿不掌握新的，也不要忘记老的，加油

LRU

移动零



盛水最多的容器

爬楼梯 ：用数组记忆递归的时候数组长度为n+1

### 2020.5.26

删除排序数组中的重复项

旋转数组

### 2020.5.27

合并两个有序的链表

##### [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

需要注意栈为空的情况，另外压入左括号还是右括号都可以

##### [155. 最小栈](https://leetcode-cn.com/problems/min-stack/)

看题解：

由于stack 先进先出的特性，所以当stack插入一个元素的时候，其之前的元素顺序是一定确定的，只要这个元素不出，其之前的元素也是不变的，所以他的最小值也是不变的，当我们插入一个新元素的时候可以也可以和之前的最小值比较，并将当前最小值保存下来。

* 标准版：一个标准栈控制入栈出栈，另一个最小栈，存放当前栈中最小的元素，当然也可以将两者封装到一起，当前元素和插入当前元素后的最小值封装。
* 空间优化版：只用一个栈和另一个变量保存最小值，每当最小值有变化，栈插入原最小值，更改最小值。如果pop出去的是最小值，则再pop一个作为新的最小值

### 2020.5.29

##### [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

* 

### 2020.5.30

##### [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

* 排序比较：先将两个字符串按照字母排序，再用equals比较是否相等。nlogn ：1

* 编码比较：将每个字符串编码为一个26维的向量，再比较向量是否相等。n ： n

* 两遍hashmap：使用其中一个建立Map(字母：次数) ,再遍历另一个字符串，对出现在map中的字母次数-1，若map中没有，或者结束后map中右字母对应的次数不为零，则失败：n： n

#### [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

* 递归：对根操作，左子树递归，右子树递归
* 迭代：可以说是对递归的模拟，需要一个栈来辅助存储之前的结果。对根操作，压入右子树，再压入左子树，因为栈是后进先出的，所以要**先压入右边**，这样左边才能先出来，左右才能有序。

### 2020.5.31

#### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

读题得解；

* HashMap ：将字母排序作为key(或者拆散存入做key，**不行，会有重复数字**)，字符串为Value

看题解

* 编码：将每一个字符串编码为一个26维度的向量，每一维为对应字母出现的次数。作为key
* 质数乘法编码，有溢出风险：每个字母编码为一个质数，字符串为质数乘积

#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

* 递归：左到底，读取，操作右子树

看题解：

* 迭代：

* 标记法：第一次是路过，第二次再读取。按照与遍历相反的顺序压入栈（中序：左根右 ，push：右根左），第一次遇见压入子节点与自己，第二次再读取

#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

* 递归

* 标记法

看题解

* 迭代：读取，压入右节点，压入左节点

#### [429. N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

* 队列，将根插入队列，出队，将子节点插入队列

看题解

* 队列，上一层队列总数是确定的，可以同时出队入队，只需要出队次数和刚进来时的size一样就行了。
* 递归，恰好结果是list<list<>>，每一层对应index ，只需要在递归是带着这个层数，子节点层数+1，自己找到对应的index添加就行

#### [面试题49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)

读题得解：

判断：一直%2直到不为0，剩下的一直%3 一直%5最后结果是否为0

* 暴力遍历

看题解：

丑数 = 丑数 * 2/3/5

预先存下来

## 三. 源码分析

##### HashMap

## 四. 日程



<center>Week2</center>

| 题目                                                         | first (plan / done) | second (plan / done) | third(plan / done) | fourth(plan / done) | fifth (plan / done) | 备注           |
| ------------------------------------------------------------ | ------------------- | -------------------- | ------------------ | ------------------- | ------------------- | -------------- |
| [Week2](#Week2)                                              | Lesson5             |                      |                    |                     |                     |                |
| [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/) |                     |                      |                    |                     |                     | [实战&习题](#) |
| [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) |                     |                      |                    |                     |                     | [实战&习题](#) |
| [Week2](#Week2)                                              | Lesson6             |                      |                    |                     |                     |                |
| [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) |                     |                      |                    |                     |                     | [实战&习题](#) |
| [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/) |                     |                      |                    |                     |                     | [实战&习题](#) |
| [590. N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/) |                     |                      |                    |                     |                     | [实战](#)      |
| [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/) |                     |                      |                    |                     |                     | [实战&习题](#) |
| [429. N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/) |                     |                      |                    |                     |                     | [实战&习题](#) |
| [Week2](#Week2)                                              | Lesson6+            |                      |                    |                     |                     |                |
| [面试题40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/) |                     |                      |                    |                     |                     | [实战](#)      |
| [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) |                     |                      |                    |                     |                     | [习题](#)      |
| [面试题49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/) |                     |                      |                    |                     |                     | [习题](#)      |
