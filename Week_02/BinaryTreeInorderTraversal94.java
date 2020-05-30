import java.util.*;

public class BinaryTreeInorderTraversal94 {
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
//        return _func1Recursive(root);
        return _func2LoopAndStack(root);
    }

    private List<Integer> _func2LoopAndStack(TreeNode root) {
         return null;
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
