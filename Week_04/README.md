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