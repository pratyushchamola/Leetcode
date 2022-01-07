int dp[10001][2][5001];

class Solution2 {
    int dp[50001][2];
public:
    int findmax(int curind,bool ownornot,vector<int>& arr){
        if(curind == arr.size())return 0;
        
        if(dp[curind][ownornot] != -1)return dp[curind][ownornot];
        
        // if i currently own a stock
        if(ownornot){
            // if i sell the stock
            int ans1 = arr[curind] + findmax(curind+1,0,arr);
            
            // if i keep the stock as it is, i.e, don't do anything
            int ans2 = findmax(curind+1,1,arr);
            
            
            return dp[curind][ownornot] = max(ans1,ans2);
        }else{
            // if i buy
            int ans1 = -(arr[curind]) + findmax(curind+1,1,arr);
            
            // keep it as it is
            int ans2 = findmax(curind+1,0,arr);
            
            return dp[curind][ownornot]= max(ans1,ans2);
        }
    }
    int maxProfit(vector<int>& prices) {
        memset(dp,-1,sizeof dp);
        
        return findmax(0,0,prices);
    }
};

class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        if(prices.size() == 0)return 0;
        
        if(k >= prices.size()/2){
            Solution2 obj;
            return obj.maxProfit(prices);
        }
        
        for(int d = prices.size()-1;d>=0;d--){
            for(int transc = 0;transc <= k;transc++){
                if(d == prices.size()-1){
                    dp[d][0][transc] = 0;
                    dp[d][1][transc] = (transc >= 1) ? prices[d] : 0;
                }else{
                    dp[d][0][transc] = max((-prices[d] + dp[d+1][1][transc]),dp[d+1][0][transc]);
                    dp[d][1][transc] = max(((transc >= 1) ? (prices[d] + dp[d+1][0][transc-1]): 0),dp[d+1][1][transc]);
                }
            }
        }
        
        return dp[0][0][k];
    }
};