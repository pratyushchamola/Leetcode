class Solution {
    int dp[5002][2][2];
public:
    int findmax(int ind,bool ifown,bool ifcool,vector<int>& arr){
        if(ind == arr.size())return 0;
        
        if(dp[ind][ifown][ifcool] != -1)return dp[ind][ifown][ifcool];
        if(ifown){
            int ans1 = arr[ind] + findmax(ind+1,0,1,arr);
            int ans2 = findmax(ind+1,1,0,arr);
            
            return dp[ind][ifown][ifcool] = max(ans1,ans2);
        }else{
            int ans1 = (ifcool == 1) ? 0 : (-arr[ind] + findmax(ind+1,1,0,arr));
            int ans2 = findmax(ind+1,0,0,arr);
            
            return dp[ind][ifown][ifcool] = max(ans1,ans2);
        }
    }
    
    int maxProfit(vector<int>& prices) {
        memset(dp,-1,sizeof dp);
        return findmax(0,0,0,prices);
    }
};