class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        vector<long> dp(501,startFuel);
        
        for(int i=0;i<stations.size();i++){
            for(int j=i;j>=0 and dp[j] >= stations[i][0];j--){
                dp[j+1] = max(dp[j+1],dp[j] + stations[i][1]);
            }
        }
        
        for(int k=0;k<=stations.size();k++){
            if(dp[k] >= target)return k;
        }
        
        return -1;
    }
};