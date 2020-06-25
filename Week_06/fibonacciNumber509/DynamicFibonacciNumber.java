package fibonacciNumber509;

public class DynamicFibonacciNumber {
    public int fib(int n) {
        int result = 0;
        result = dynamicLoop(n);
        recursiveCache = new int[n+1];
        result = dynamicRecursive(n);
        return result;
    }
    int[] recursiveCache ;
    public int dynamicRecursive(int n){
        if(n <= 1) return n;

        if(recursiveCache[n]==0){
            recursiveCache[n] = dynamicRecursive(n-1) + dynamicRecursive(n-2);
        }
        return recursiveCache[n];
    }

    public int dynamicLoop(int n){
        if(n <= 1) return n;
        int[] dynamic = new int[n+1];
        dynamic[0] = 0;
        dynamic[1] = 1;
        for (int i = 2; i <= n; i++) {
            dynamic[i] = dynamic[i-1] + dynamic[i-2];
        }
        return dynamic[n];
    }
}
