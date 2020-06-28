package fibonacciNumber509;

public class Second {
    public void init(int n){
        dynamicCache = new int[n+1];
    }

    public int idoitRecursive(int n){
        return n > 1 ? idoitRecursive(n-1) + idoitRecursive(n-2) : n;

    }
    int [] dynamicCache ;
    public int dynamicRecursive(int n) {

        if ( n <= 1 ) {
            return n;
        }
        if(dynamicCache[n] == 0) {
            dynamicCache[n] = dynamicRecursive(n-1) + dynamicRecursive(n-2);
        }
        return dynamicCache[n];
    }

    public int dynamicLoop(int n){
        if(n <= 1) return n;
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int dynamicTwoNum(int n){
        if ( n<= 1) return n;
        int left = 0;
        int mid = 1;
        for ( int i = 2 ; i <= n ; ++ i) {
            int now = left + mid;
            left = mid;
            mid = now;
        }
        return mid;
    }
}
