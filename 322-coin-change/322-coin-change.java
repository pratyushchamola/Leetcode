class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]= new int[amount+1];
        
        Arrays.sort(coins);
        
        for(int j=0;j<=amount;j++)dp[j] = -1;
        
        int ans = findans(coins,amount,dp);
        
        
        if(ans == Integer.MAX_VALUE-1)return -1;
        return ans;
        
    }
    
    public int findans(int[] coins,int amt,int[] dp){
        if(amt == 0)return 0;
        
        if(dp[amt] != -1)return dp[amt];
        
        int ans = Integer.MAX_VALUE - 1;
        
        for(int i=coins.length-1;i>=0;i--){
            if(coins[i] <= amt){
                ans = Math.min(ans,1 + findans(coins,amt - coins[i],dp));
            }
        }
        
        dp[amt] = ans;
        
        return ans;
    }
}