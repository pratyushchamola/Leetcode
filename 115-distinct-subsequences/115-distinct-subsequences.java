class Solution {
    public int dp[][] = new int[1001][1001];
    public int findans(String s,String t,int sind,int tind){
        if(tind <= 0)return 1;
        if(sind <= 0)return 0;
        
        if(dp[sind][tind] != -1)return dp[sind][tind];
        
        int ans = 0;
        
        if(s.charAt(sind-1) == t.charAt(tind-1))ans += findans(s,t,sind-1,tind-1);
        ans += findans(s,t,sind-1,tind);
        
        return dp[sind][tind] = ans;
    }
    public int numDistinct(String s, String t) {
        
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                dp[i][j] = -1;
            }
        }
        int sz = s.length();
        int tz = t.length();
        
        return findans(s,t,sz,tz);
    }
}