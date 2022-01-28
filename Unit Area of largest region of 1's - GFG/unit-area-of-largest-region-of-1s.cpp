// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
    public:
    //Function to find unit area of the largest region of 1s.
    
    int dx[8] = {0,1,0,-1,1,-1,1,-1};
    int dy[8] = {1,0,-1,0,1,-1,-1,1};
    void dfs(vector<vector<int>>& arr,int& curcnt,int row,int col,vector<vector<int>>& vis){
        if(row < 0 || col < 0 || row >= arr.size() || col >= arr[0].size() || vis[row][col]==1 || arr[row][col] != 1)return;
        
        
        
        vis[row][col] = 1;
        
        curcnt++;
        for(int i=0;i<8;i++){
            int newrow = row + dy[i];
            int newcol = col + dx[i];
            
            dfs(arr,curcnt,newrow,newcol,vis);
        }
        
    }
    int findMaxArea(vector<vector<int>>& grid) {
        // Code here
        int ans = 0;
        
        vector<vector<int>> visited(grid.size(),vector<int>(grid[0].size(),0));
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[i].size();j++){
                int cnt = 0;
                
                if(grid[i][j] == 1 && visited[i][j]==0)dfs(grid,cnt,i,j,visited);
                
                // ans = max(ans,cnt);
                // ans += cnt;
                ans = max(ans,cnt);
            }
        }
        
        return ans;
    }
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>>grid(n, vector<int>(m, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.findMaxArea(grid);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends