import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
//        return _func1Recursive(root);
//        return _func2LoopAndStack(root);
        return _func3LoopAndMark(root);
    }

    private class LoopNode{
        TreeNode val;
        boolean visited;
        public LoopNode(TreeNode node , boolean b) {
            this.val = node;
            this.visited = b;
        }
    }

    private List<Integer> _func3LoopAndMark(TreeNode root) {
        Stack<LoopNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        stack.push(new LoopNode(root,false));
        while (!stack.empty()) {
            LoopNode ln = stack.pop();
            if(ln.val == null) continue;
            if(ln.visited == false) {
                stack.push(new LoopNode(ln.val.right , false));
                stack.push(new LoopNode(ln.val.left,false));
                stack.push(new LoopNode(ln.val,true));
            } else {
                result.add(ln.val.val);
            }
        }
        return result;
    }

    private List<Integer> _func2LoopAndStack(TreeNode root) {
        List<Integer> result  = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while(!stack.empty() ) {
            node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left !=  null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    private List<Integer> _func1Recursive(TreeNode root) {
        List<Integer> result = new LinkedList<>();
//        if(root == null) return result;
        preorderRecursive(root , result);
        return result;
    }

    private void preorderRecursive(TreeNode root, List<Integer> result) {
        if (root != null){
            result.add(root.val);
            preorderRecursive(root.left , result);
            preorderRecursive(root.right , result);
        }
    }

}
