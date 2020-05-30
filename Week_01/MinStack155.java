import java.util.Arrays;
import java.util.Stack;

public class MinStack155 {


    Stack<Integer> stack;
    Integer minValue;
    /** initialize your data structure here. */
    public MinStack155() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (minValue == null ) {
           stack.push(minValue);
           minValue = x;
        } else if ( minValue.intValue() >= x ) {
            stack.push(minValue);
            minValue = x;
        }

        stack.push(x);
    }

    public void pop() {
        Integer p = stack.pop();
        if (p.equals(minValue)) {
           minValue = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
    public static void main(String[] args) {
        MinStack155  m = new MinStack155();
        m.push(4);
        m.push(6);
        m.getMin();
        m.getMin();
        m.push(3);
        m.getMin();
        m.getMin();
        m.top();
        m.getMin();
        m.pop();
        m.push(8);
        m.push(1);
        m.getMin();
        m.push(5);
        m.pop();
        m.top();
        m.getMin();
        m.pop();
    }

}
 class MinStack155Stander{
    Stack<Integer> stack ;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack155Stander () {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x) ;
        if (x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}


class MinStack155ArrayStack{
    int[] stack;
    int[] minStack;
    int top = 0;
    int minTop = 0;
    int capacity = 10;
    Integer min = null;
    /** initialize your data structure here. */
    public MinStack155ArrayStack() {
        stack = new int[capacity];
    }

    public void push(int x) {
        if (top >= capacity) {
            capacity = capacity << 1;
            int[] newStack = new int[capacity];
            System.arraycopy(stack,0,newStack,0,stack.length);
            stack = newStack;
        }
        stack[top++] = x;
        if(min == null) getMin();
        if(min.equals(null) || x < min) min = x;
    }

    public void pop() {
        if (top() == min ) {
            min = null;
        }

        --top;
    }

    public int top() {
        if(top > 0)
            return stack[top-1];
        else
            return -1;
    }
    public int getMin() {
        if( min != null) {
            return min;
        }
        min = stack[0];
        for (int i = 1; i < top; i++) {
            if (stack[i] < min) {
                min = stack[i];
            }
        }
        return min;
    }
}
