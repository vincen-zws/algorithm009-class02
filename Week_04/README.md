[深度优先搜索、广度优先搜索](https://u.geekbang.org/lesson/14?article=243705)

[贪心算法](https://u.geekbang.org/lesson/14?article=243734)

[二分查找](https://u.geekbang.org/lesson/14?article=243741)

## 一. 知识点

1. 深度优先搜索dfs

   图搜索要有visited集合

   - 递归代码

   - ```java
     Set visited = new HashSet();
     public void dfs(Node node) {
         if (visited.contain(node)) return;
         visited.add(node);
         for(Node nextNode : node.children) {
             if ( !visited.contain(nextNode)) {
                 dfs(nextNode);
             }
         }
     }
     ```

   - 非递归 栈辅助

   - ```java 
     public void dfs(Node node) {
         if (node == null) return;
         Stack stack = new Stack;
         Set visited = new HashSet();   
         stack.push(node);
         while(!stack.empty()){
             Node nextNode = stack.pop();
             visited.add(nextNode);
             for(Node nextNode : node.children) {
             	if ( !visited.contain(nextNode)) {
                 	stack.push(nextNode);
             	}
         	}
         }
     }
     ```

   - 

2. 广度优先搜索bfs

   图搜索要有visited集合

   - 非递归 队列辅助

   - ```java
     public void bfs(Node node) {
         Set visited = new HashSet();
         Queue queue = new ArrayList();
         queue.add(node);
         visited.add(node);
         while(!queue.empry()){
             Node nodeNext = queue.pop();
             visited.add(nodeNoext);
             process(nodeNext);
             for(Node nextNode : node.children) {
             	if ( !visited.contain(nextNode)) {
                 	queue.push(nextNode);
             	}
         	}
         }
     }
     ```

3. 贪心

   - ​	

   - 贪心与动态规划：

     - 贪心：对于每个子问题的解决方案都做出选择，不能回退；

       **当下局部最优+不能回退**

     - 动态规划：会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能；

       **最优判断+回退**

   - 贪心由于不能做到全局最优，所以一般配合其他算法做全局，只在局部贪心

   - 一般用来做最优化问题（最近，最小），最小生成树，哈夫曼编码

   - 能用贪心解决，则贪心一般就是最好办法，贪心法也肯做辅助算法或者解决一些结果要求不是很精确的问题（高效+接近最优解）

4. 二分查找

   - **前提条件** 目标函数单调，有上下界，通过索引访问

   - ```java
     int left = 0;
     int right = array.length-1;
     while(left <= right) {
         int mid = left (right - left) >> 1
         if (array[mid] == target ) return ;
         else if(array[mid] < target)  left = mid + 1;
         else right = mid - 1 ;
     }
     //index 为实数集的话就不用+1 -1
     ```

   - 

## 二. 习题

### 2020.6.14

#### [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)





#### [529. 扫雷游戏](https://leetcode-cn.com/problems/minesweeper/)



## 三. 日程

<center>Week4</center>

| 题目                                                         | first (plan / done) | second (plan / done) | third(plan / done) | fourth(plan / done) | fifth (plan / done) | 备注      |
| ------------------------------------------------------------ | ------------------- | -------------------- | ------------------ | ------------------- | ------------------- | --------- |
| [Week4](#Week4)                                              | Lesson9             |                      |                    |                     |                     |           |
| [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) |                     |                      |                    |                     |                     | [实战](#) |
| [433. 最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/) |                     |                      |                    |                     |                     | [实战](#) |
| [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/) |                     |                      |                    |                     |                     | [实战](#) |
| [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/) |                     |                      |                    |                     |                     | [习题](#) |
| [126. 单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/) |                     |                      |                    |                     |                     | [习题](#) |
| [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) |                     |                      |                    |                     |                     | [习题](#) |
| [529. 扫雷游戏](https://leetcode-cn.com/problems/minesweeper/) |                     |                      |                    |                     |                     | [习题](#) |
| [Week4](#Week4)                                              | Lesson10            |                      |                    |                     |                     |           |
| [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/) |                     |                      |                    |                     |                     | [实战](#) |
| [860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/) |                     |                      |                    |                     |                     | [习题](#) |
| [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) |                     |                      |                    |                     |                     | [习题](#) |
| [455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/) |                     |                      |                    |                     |                     | [习题](#) |
| [874. 模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/) |                     |                      |                    |                     |                     | [习题](#) |
| [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)  |                     |                      |                    |                     |                     | [习题](#) |
| [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/) |                     |                      |                    |                     |                     | [习题](#) |
| [Week4](#Week4)                                              | Lesson11            |                      |                    |                     |                     |           |
| [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)    |                     |                      |                    |                     |                     | [实战](#) |
| [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/) |                     |                      |                    |                     |                     | [实战](#) |
| [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) |                     |                      |                    |                     |                     | [习题](#) |
| [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/) |                     |                      |                    |                     |                     | [习题](#) |
| [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) |                     |                      |                    |                     |                     | [习题](#) |
