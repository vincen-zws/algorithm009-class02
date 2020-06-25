package uniquePaths62;

public class dynamicLoopUniquePaths {

    public int uniquePaths(int m, int n) {
//        return dynamicLoop2(m,n);
        return dynamicLoop1(m,n);
    }

    private int dynamicLoop2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }

    private int dynamicLoop1(int m, int n) {
       int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < m; i++) {
            int preCol = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + preCol;
                preCol = dp[j];
            }
        }
        return dp[n-1];
    }




}
