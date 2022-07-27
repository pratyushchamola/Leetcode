class Solution {
    public static double mod = 1e9+7;
    public static int[][][] check;
    
    public double solve(int row,int col,int n){
        if(row < 0 || col < 0 || row >= 4 || col >= 3 || n <=0)return 0;
        if((row == 3) && ((col == 0) || (col == 2)))return 0;
        
        if(n == 1){
            // ans.add(curs);
            return 1;
        }
        
        if(check[n][row][col] != -1){
            return check[n][row][col];
        }
        
        double ans = 0;
        ans  = (ans%mod + solve(row+2,col+1,n-1)%mod)%mod;
        ans  = (ans%mod + solve(row+2,col-1,n-1)%mod)%mod;
        ans  = (ans%mod + solve(row+1,col+2,n-1)%mod)%mod;
        ans  = (ans%mod + solve(row+1,col-2,n-1)%mod)%mod;
        ans  = (ans%mod + solve(row-2,col+1,n-1)%mod)%mod;
        ans  = (ans%mod + solve(row-2,col-1,n-1)%mod)%mod;
        ans  = (ans%mod + solve(row-1,col+2,n-1)%mod)%mod;
        ans  = (ans%mod + solve(row-1,col-2,n-1)%mod)%mod;
        
        check[n][row][col] = (int)ans;
        return check[n][row][col];
    }
    
    public int knightDialer(int n) {
        check = new int[n+1][5][4];
        
        for(int i=0;i<=n;i++){
            for(int row = 0;row<5;row++){
                for(int col=0;col<4;col++)check[i][row][col] = -1;
            }
        }
        
        double ans = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if((i == 3) && (j == 0 || j == 2))continue;
                ans = (ans%mod + solve(i,j,n)%mod)%mod;
            }
            ans = ans%mod;
        }
        
        return (int)ans;
    }
}