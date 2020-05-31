import review.ClimbingStairs70_3;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal429 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

    }

    public List<List<Integer>> levelOrder(Node root) {
        //myself
//        return _func1LoopAndQueueAlternate(root);
        //solution
//        return _func2LoopAndQueue(root);
        return _func3Recursive(root);
    }

    private List<List<Integer>> _func3Recursive(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if( root != null) recursive(root , result , 0);
        return result;
    }

    private void recursive(Node root, List<List<Integer>> result , int level) {
        if(result.size() <= level) {
            result.add(new LinkedList<>());
        }
        if ( root != null) {
            result.get(level).add(root.val);
            for (Node node : root.children) {
                recursive(node,result,level + 1);
            }
        }
    }

    private List<List<Integer>> _func2LoopAndQueue(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList();

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                level.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            result.add(level);
        }
        return result;
    }

    private List<List<Integer>> _func1LoopAndQueueAlternate(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue tempQueue = new ArrayDeque();
            List listLevel = new LinkedList();
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                listLevel.add(node.val);
                for (int i = 0; i < node.children.size(); i++) tempQueue.offer(node.children.get(i));
            }
            result.add(listLevel);
            queue = tempQueue;
        }
        return result;
    }
}
