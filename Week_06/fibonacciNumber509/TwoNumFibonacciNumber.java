package fibonacciNumber509;

public class TwoNumFibonacciNumber {
    public int fib(int N) {
        if(N<=1) return N;
        int pre1 = 0;
        int pre2 = 1;
        for (int i = 2; i <= N; i++) {
            int current = pre1 + pre2;
            pre1 = pre2;
            pre2 = current;
        }
        return pre2;
    }
}
