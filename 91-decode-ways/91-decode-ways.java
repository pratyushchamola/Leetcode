class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        
        for(int i=0;i<s.length();i++)dp[i] = -1;
        
        return findans(s,dp,0);
    }
    
    public int findans(String s,int[] dp,int ind){
        if(ind >= s.length())return 1;
        
        if(dp[ind] > -1)return dp[ind];
        
        int val = (int)(s.charAt(ind) - '0');
        
        if(val == 0){
            dp[ind] = 0;
            return 0;
        }
        
        int count = 0;
        count = findans(s,dp,ind+1);
        
        if(ind+1 < s.length()){
            int val2 = (int)(s.charAt(ind+1) - '0');
            
            if((val == 1) || (val == 2 && val2 <= 6)){
                count += findans(s,dp,ind+2);
            }
        }
        
        dp[ind] = count;
        
        return count;
        
        
        
    }
}