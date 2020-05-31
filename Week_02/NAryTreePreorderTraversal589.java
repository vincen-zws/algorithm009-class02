import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
//        return _func1Recursive(root);
        return _func2LoopAndStack(root);
//        return

    }

    private List<Integer> _func2LoopAndStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        List<Integer> result = new LinkedList<>();
        stack.push(root);
        while(!stack.empty()) {
            node = stack.pop();
            result.add(node.val);
            for( int i = node.children.size() -1 ; i >= 0 ; --i) {
                Node child = node.children.get(i);
                stack.push(child);
            }

        }
        return result;
    }

    private List<Integer> _func1Recursive(Node root) {
        List<Integer> result = new LinkedList<>();
        return _func1Handle(root , result);
    }

    private List<Integer> _func1Handle(Node root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        for (Node child:root.children) {
            _func1Handle(child,result);
        }
        return result;
    }

}
