class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        int sum = 0;
        for(auto child:piles)sum += child;
        
        vector<vector<int>> dp(piles.size(),vector<int>(piles.size(),0));
        int n = piles.size();
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0)dp[i][j] = piles[i];
                else if(g==1)dp[i][j] = max(piles[i],piles[j]);
                else{
                    int val1 = piles[i] + min(dp[i+2][j],dp[i+1][j-1]);
                    int val2 = piles[j] + min(dp[i][j-2],dp[i+1][j-1]);
                    
                    dp[i][j] = max(val1,val2);
                }
            }
        }
        
        return (dp[0][piles.size()-1]*2 > sum);
    }
};