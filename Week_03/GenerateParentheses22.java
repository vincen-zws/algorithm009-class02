import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
//        return _func1RecursiveCheck(n);
        return _func2StackSimiRecursive(n);
    }

    private List<String> _func2StackSimiRecursive(int n) {
        class Node{
            String str;
            int left;
            int right;
            public Node(String s, int l, int r) {
                str = s;
                left = l;
                right = r;
            }
            public boolean check() {
                return left <= right;
            }
        }
        Stack<Node> stack = new Stack<>();
        List<String> result = new LinkedList<>();
        String str = "(";
        stack.push(new Node(str,n-1,n));
        while (!stack.empty()){
            Node node = stack.pop();
            int left = node.left , right = node.right;
            String s = node.str;
            if (left == 0 && right == 0 ) {
                result.add(s);
                continue;
            }
            if (left - 1 <= right && left != 0) stack.push(new Node(s + "(",left-1,right));
            if (left <= right - 1 && right != 0) stack.push(new Node(s+")",left,right-1));
        }
        return result;
    }

    private List<String> _func1RecursiveCheck(int n) {
        List<String> result = new LinkedList<>();
        int left = n-1 , right = n;
        String str = "(";
        _func1handle(result,str,left,right);
        return result;
    }

    private void _func1handle(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if(left > right || left < 0 || right < 0){
            return;
        }
        if (left-1 <= right && left != 0) _func1handle(result,str+"(", left-1,right);
        if (left <= right-1 && right != 0) _func1handle(result,str+")",left,right-1);
    }


    public static void main(String[] args) {
        GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
        System.out.println(generateParentheses22.generateParenthesis(2).toString());
    }
}
