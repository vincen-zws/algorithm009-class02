import java.util.*;

public class BinaryTreeInorderTraversal94 {
     private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
         if(root == null) {
             return new LinkedList<>();
         }
//        return _func1Recursive(root);
//        return _func2LoopAndStack(root);
         return _func3LoopAndMark(root);
    }

    private List<Integer> _func3LoopAndMark(TreeNode root) {
         Stack<LoopNode> stack = new Stack<>();
         List<Integer> result = new LinkedList<>();
         stack.push(new LoopNode(root,false));
         while(!stack.empty()) {
             LoopNode ln = stack.pop();
             if (ln.val == null) continue;
             if (ln.visited == false) {
                 stack.push(new LoopNode(ln.val.right,false));
                 stack.push(new LoopNode(ln.val,true));
                 stack.push(new LoopNode(ln.val.left,false));
             } else {
                 result.add(ln.val.val);
             }
         }
         return result;
    }

    class LoopNode{
         TreeNode val;
         boolean visited;
         public LoopNode(TreeNode node , boolean b) {
             this.val = node;
             this.visited = b;
         }
    }

    private List<Integer> _func2LoopAndStack(TreeNode root) {
         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
         TreeNode node =  root;
         List<Integer> result = new LinkedList<>();
         do{
             while (node != null) {
                stack.push(node);
                node = node.left;
             }
             node = stack.pop();
             result.add(node.val);
             node = node.right;
         }while(!stack.empty());
        return result;
    }

    private List<Integer> _func1Recursive(TreeNode root) {
        List<Integer> result = new LinkedList();
        inorderRecursive(root,result);
        return result;
    }

    public void inorderRecursive(TreeNode root, List<Integer> result) {
         if (root != null) {
             inorderRecursive(root.left, result);
             result.add(root.val);
             inorderRecursive(root.right, result);
         }
    }
}
