class Solution {
public:
    int rows,cols;
    int findans(vector<vector<int>>& arr,int currow,int prevind,int curans){
        if(currow >= rows)return curans;
        
        return min(findans(arr,currow+1,prevind,curans + arr[currow][prevind]),findans(arr,currow+1,prevind+1,curans + arr[currow][prevind+1]));
    }
    
    int minimumTotal(vector<vector<int>>& triangle) {
        rows = triangle.size();
        cols = triangle[rows-1].size();
        // return findans(triangle,1,0,triangle[0][0]);
        
        vector<vector<int>> dp(rows+1,vector<int>(cols+1,0));
        
        dp[0][0] = triangle[0][0];
        for(int i=1;i<rows;i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][triangle[i].size()-1] = dp[i-1][triangle[i].size()-2] + triangle[i][triangle[i].size()-1];
            for(int j=1;j<triangle[i].size()-1;j++){
                dp[i][j] = min(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j];
            }
        }
        
        return *min_element(dp[rows-1].begin(),dp[rows-1].begin()+cols);
    }
};