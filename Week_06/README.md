[动态规划](https://u.geekbang.org/lesson/14?article=247869)

## 一. 知识点

dynamic programming

1. 动态规划与递归、分治

   没有根本上的区别，关键看有无最优子结构

   同：找到重复子问题

   异：最优子结构、中途可以淘汰次优解

2. 动态规划 约等 分治 +最优子结构

   每一步从多个子问题中选择最优状态

   保留之前每个子问题的最优状态，从而推导全局最优

   递推方程

   一般最值，最优解 之类的问题

3. 技巧

   自顶向下：递归

   自底向上：循环

   一维基础：斐波拉契数列

   二维基础：路径计数

动态规划问题的一般形式就是求最值,求解动态规划的核心问题是穷举,穷举所有求最值。算法设计无非就是先思考“如何穷举”，然后再追求“如何聪明地穷举”。

明确「状态」 -> 定义 dp 数组/函数的含义 -> 明确「选择」-> 明确 base case。

  状态表示：状态转移，边界情况；



## 二. 习题

##### [509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)

- 傻递归
- 动态规划（递归->自顶向下/循环->自底向上）
- 两个数字的动态规划

##### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

- 动态规划（递归->自顶向下/循环->自底向上）
- 一维数组的动态规划

## 三. 日程

<center>Week6</center>



| 题目                                                         | first (plan / done)   | second (plan / done)  | third(plan / done) | fourth(plan / done) | fifth (plan / done) | 备注                                                         |
| ------------------------------------------------------------ | --------------------- | --------------------- | ------------------ | ------------------- | ------------------- | ------------------------------------------------------------ |
| [509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/) | 2020.6.25 / 2020.6.25 | 2020.6.25 / 2020.6.25 | 2020.6.26 /        | 2020.7.2 /          |                     | [实战](#509. 斐波那契数)                                     |
| [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/) | 2020.6.25 / 2020.6.25 | 2020.6.25 / 2020.6.25 |                    |                     |                     | [实战](#[62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)) |
| [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) |                       |                       |                    |                     |                     | [实战](#)                                                    |
| [三角形最小路径和高票回答](https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)) |                       |                       |                    |                     |                     | 题解                                                         |
| [动态规划套路详解](https://leetcode-cn.com/problems/fibonacci-number/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-labuladong/) |                       |                       |                    |                     |                     | 题解                                                         |
| [一个方法团灭 6 道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/) |                       |                       |                    |                     |                     | 题解                                                         |
| [279. 完全平方数](https://leetcode-cn.com/problems/perfect-squares/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)  |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [980. 不同路径 III](https://leetcode-cn.com/problems/unique-paths-iii/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [621. 任务调度器](https://leetcode-cn.com/problems/task-scheduler/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [363. 矩形区域不超过 K 的最大数值和](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [403. 青蛙过河](https://leetcode-cn.com/problems/frog-jump/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [552. 学生出勤记录 II](https://leetcode-cn.com/problems/student-attendance-record-ii/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/) |                       |                       |                    |                     |                     | [习题](#)                                                    |
| [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/) |                       |                       |                    |                     |                     | [习题](#)                                                    |

