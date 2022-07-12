class Solution {
    public int[][] dp;
    public int n,m;
    
    public int[] dx,dy;
    public int findans(int[][] grid,int row,int col,int prevval){
        if(row >= n || col >= m || col < 0 || row < 0)return -1;
        
        if((prevval != -1) && (prevval <= grid[row][col]))return -1;
        
        if(dp[row][col] != -1)return dp[row][col];
        
        int ans = 1;
        
        // System.out.println("row + col : " + row + " " + col + " cnt : " + cnt);
        for(int i=0;i<4;i++){
            int newrow = row + dx[i];
            int newcol = col + dy[i];
            
            ans = Math.max(ans,1 + findans(grid,newrow,newcol,grid[row][col]));
        }
        
        
        // System.out.println("row + col : " + row + " " + col + " cnt : " + cnt);
        
        return dp[row][col] = ans;
        
    }
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[200][200];
        
        dx = new int[]{0,0,1,-1};
        dy = new int[]{1,-1,0,0};
        
        for(int i=0;i<200;i++){
            Arrays.fill(dp[i],-1);
        }
        n = matrix.length;
        m = matrix[0].length;
        int ans = -1;
        for(int row = 0;row<n;row++){
            for(int col =0 ;col<m;col++){
                ans = Math.max(ans,findans(matrix,row,col,-1));
                System.out.println("row : " + row + " col: " + col + " maxans : " + ans);
            }
        }
        
        return ans;
    }
}