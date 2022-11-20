class Solution {
public:
    vector<int> check = {0,1,0,-1,0};
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<pair<int,int>,int>> q;
        
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2)q.push({{i,j},0});
            }
        }
        
        int ans = 0;
        
        while(!q.empty()){
            auto [r,c] = q.front().first;
            int score = q.front().second;
            q.pop();
            for(int i=0;i<4;i++){
                int cr = r + check[i];
                int cc = c + check[i+1];
                
                if(cr < 0 or cc < 0 or cr >= n or cc >= m or grid[cr][cc] != 1)continue;
                
                ans = max(ans,score+1);
                grid[cr][cc] = 2;
                q.push({{cr,cc},score+1});
            }
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1)ans = -1;
            }
        }
        
        return ans;
    }
};