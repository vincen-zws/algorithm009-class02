package uniquePaths62;

public class Second {
    public int uniquePaths(int m, int n) {
        int row = m - 1 , col = n - 1;
        init(row,col);
//        return idoitRecursive(row,col);
//        return dynamicRecursive(row,col);
//        return dynamicLoop(row,col);
        return dynamic1dimLoop(row,col);
    }
    int[][] dynamicCache ;
    public void init ( int m , int n){
        dynamicCache =new int[m+1][n+1];
    }
    public int idoitRecursive(int m , int n){
        if(m == 0 || n == 0) {
            return 1;
        }
        return idoitRecursive(m - 1 ,n) + idoitRecursive(m , n - 1);

    }

    public int dynamicRecursive(int m ,int n){
        if( m == 0 || n == 0) {
            return 1;
        }
        if (dynamicCache[m][n] == 0){
            dynamicCache[m][n] = dynamicRecursive(m-1,n) + dynamicRecursive(m,n-1);
        }
        return dynamicCache[m][n];
    }

    public int dynamicLoop(int m , int n){
        for( int i = 0 ; i <= n ; ++i) dynamicCache[0][i] = 1;
        for( int i = 1 ; i <= m ; ++i) dynamicCache[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dynamicCache[i][j] = dynamicCache[i-1][j] + dynamicCache[i][j-1];
            }
        }
        return dynamicCache[m][n];
    }

    public int dynamic1dimLoop(int m , int n){
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) dp[i] = 1;

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n];
    }
}
