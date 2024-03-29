class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        
//         1 1 1
//         1 1 1
//         0 1 1
            
//         1 1 1
//         1 2 2
//         0 1 3
        
        for(int i=0;i<n;i++)dp[i][0] = matrix[i][0];
        for(int i=0;i<m;i++)dp[0][i] = matrix[0][i];
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(matrix[i][j] == 1)dp[i][j] = 1;
                if(matrix[i-1][j] == 1 && matrix[i][j-1] == 1 && matrix[i][j] == 1)dp[i][j] += Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)ans += dp[i][j];
        }
        
        return ans;
    }
}