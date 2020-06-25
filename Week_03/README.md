# Week3

[泛型递归、树的递归](https://u.geekbang.org/lesson/14?article=241750)

[分治、回溯](https://u.geekbang.org/lesson/14?article=241754)

## 一. 知识点

1. 递归

   - 函数调用与盗梦空间

     向下调用其他函数，向上返回调用该函数的部分

     通过参数返回上一层

     每一层周围的环境都是一份拷贝，只有 传递的参数菜发生变化

   - 代码实现

     终止条件

     当前处理

     下探

     清理（可选）

     

     ```java
     public void recur(int level, int param){
         
         //terminator
         if(level >MAX_LEVEL){
             return;
         }
         //current logic
         process(level,param);
         //drill down
         recur(level+1,newParam)
     	//restore current status
     
     }
     ```

     

   - 思维要点

     不要人肉递归，不可想清楚每一步递归过程，初学可以在纸上画几步递归树

     找到最近最简子问题，将其拆解为可重复解决的问题（重复子问题）

     数学归纳法的思维

     

2. 分治、回溯

   分治和回溯是一种解决问题的思想，通常用递归来实现，即递归是一种解决问题的方法，很适合解决这几种问题。分治是将问题分解为多个子问题，再将多个子问题组合成该问题的解（分解，组合）。回溯是尝试问题可能的解，并判断是否可行决定得到解还是回退。

   而用递归解决问题最重要的是找到重复性，最近/最优

   - 回溯

     解决一个回溯问题，实际上就是一个决策树的遍历过程。你只需要思考 3 个问题：

     1、路径：也就是已经做出的选择。

     2、选择列表：也就是你当前可以做的选择。

     3、结束条件：也就是到达决策树底层，无法再做选择的条件。

     如果你不理解这三个词语的解释，没关系，我们后面会用「全排列」和「N 皇后问题」这两个经典的回溯算法问题来帮你理解这些词语是什么意思，现在你先留着印象。

     代码方面，回溯算法的框架：

         result = []
         def backtrack(路径, 选择列表):
             if 满足结束条件:
                 result.add(路径)
                 return
         for 选择 in 选择列表:
             做选择
             backtrack(路径, 选择列表)
             撤销选择

     

## 二. 习题



#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

得到这样几个特性：1.最左最右是确定的（），2。每一步左括号大于右括号，总括号数量一定。

读题得解：

1. 递归：每次压入左括号或者右括号，，检测长度足够且括号数量正确即为结果。括号数量不正确则退出。
2. 栈模拟：通过栈模拟递归，每次压入中间结果。

看题解：

1.动态规划：dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]

#### [51. N皇后](https://leetcode-cn.com/problems/n-queens/)

读题得解：

1：回溯：f(n) = f(n-1)试错

看题解：

按列编程，约束编程

n皇后问题同行，同列好判断。同对角线判断为，从左至右 col - row 同对角线一致，从右至左，col + row 一致 ,方阵均有

### 2020.6.10

#### [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

读题得解：

回溯：当前选择 + 可选择字母 -》下一层 ，擦除当前选择。

看题解：

递归和回溯都可以做，本质上差别不大，关键在于，回溯要求做完之后要擦除操作，而一般递归不用，所以回溯用stringbuilder，一般递归用普通的String ,因为String + String ,生成一个新的对象String,没有在原来的对象上修改。

这也是符合逻辑的，生成多个结果，要么就在一个地方擦写，要么就写在多个地方。

Queue：几个很妙的点 。’1‘ - ’0‘ = 1 ，将其作为index,再用Array 就是一个map。nextIndex  = current String.length



## 三. 日程



<center>Week3</center>

| 题目                                                         | first (plan / done) | second (plan / done) | third(plan / done) | fourth(plan / done) | fifth (plan / done) | 备注      |
| ------------------------------------------------------------ | ------------------- | -------------------- | ------------------ | ------------------- | ------------------- | --------- |
| [Week3](#Week3)                                              | Lesson7             |                      |                    |                     |                     |           |
| [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/) |                     |                      |                    |                     |                     | [实战](#) |
| [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/) |                     |                      |                    |                     |                     | [实战](#) |
| [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/) |                     |                      |                    |                     |                     | [实战](#) |
| [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) |                     |                      |                    |                     |                     | [实战](#) |
| [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/) |                     |                      |                    |                     |                     | [实战](#) |
| [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/) |                     |                      |                    |                     |                     | [实战](#) |
| [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) |                     |                      |                    |                     |                     | [习题](#) |
| [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) |                     |                      |                    |                     |                     | [习题](#) |
| [77. 组合](https://leetcode-cn.com/problems/combinations/)   |                     |                      |                    |                     |                     | [习题](#) |
| [46. 全排列](https://leetcode-cn.com/problems/permutations/) |                     |                      |                    |                     |                     | [习题](#) |
| [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/) |                     |                      |                    |                     |                     | [习题](#) |
| [Week3](#Week3)                                              | Lesson8             |                      |                    |                     |                     |           |
| [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)    |                     |                      |                    |                     |                     | [实战](#) |
| [78. 子集](https://leetcode-cn.com/problems/subsets/)        |                     |                      |                    |                     |                     | [实战](#) |
| [169. 多数元素](https://leetcode-cn.com/problems/majority-element/) |                     |                      |                    |                     |                     | [实战](#) |
| [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) |                     |                      |                    |                     |                     | [实战](#) |
| [51. N皇后](https://leetcode-cn.com/problems/n-queens/)      |                     |                      |                    |                     |                     | [实战](#) |

