package uniquePaths62;

public class dynamicRecursiveUniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        return dynamicRecursive(m,n,dp);
    }



    private int dynamicRecursive(int m, int n, int[][] dp) {

        if(m == 1 || n ==1) {
            return 1;
        }
        if(dp[m-1][n-1] == 0) {
            dp[m-1][n-1] = dynamicRecursive(m-1,n,dp) + dynamicRecursive(m,n-1,dp);
        }
        return dp[m-1][n-1];
    }

}
