class Solution {
public:
    vector<vector<double>> dir = {{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
    
    double dp[26][26][101];
    double solve(int n,int k,int row,int column){
        // moves++;
        if(row < 0 || column < 0 || row >=n || column  >= n){
            // outof++;
            return 0;
        }
        if(k == 0)return 1;
        
        if(dp[row][column ][k] != 0)return dp[row][column][k];
        
        double curans = 0;
        for(int i=0;i<dir.size();i++){
            curans += 0.125 * solve(n,k-1,row + dir[i][0],column + dir[i][1]);
        }
        
        return dp[row][column][k] = curans;
        
    }
    
    double knightProbability(int n, int k, int row, int column) {
        
        return solve(n,k,row,column);
        
    }
};