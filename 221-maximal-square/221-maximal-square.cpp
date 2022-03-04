class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        
        vector<vector<int>> dp(rows+1,vector<int>(cols+1,0));
        int ans = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!i || !j || matrix[i][j]=='0'){
                    dp[i][j] = matrix[i][j] - '0';
                }else{
                    dp[i][j] = min({dp[i-1][j-1],dp[i][j-1],dp[i-1][j]}) + 1;
                }
                
                ans = max(ans,dp[i][j]);
            }
        }
        
        return ans*ans;
    }
};