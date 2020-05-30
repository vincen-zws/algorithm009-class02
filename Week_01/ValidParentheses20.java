import java.util.*;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        if (s==null) {
           return false;
        }
//        return _func1Stack(s);
        return _func2HashAndStack(s);
        
    }

    private boolean _func2HashAndStack(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.empty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    private boolean _func1Stack(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c :s.toCharArray()) {
            if (c == '{' ) {
                stack.push('}');
            } else if(c == '(') {
                stack.push(')');
            } else if(c == '[') {
                stack.push(']');
            } else {
                if (stack.empty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
