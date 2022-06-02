class Solution {
public:
    int dx[8] = {1,1,0,-1,-1,-1,0,1};
    int dy[8] = {0,-1,-1,-1,0,1,1,1};
    
    void gameOfLife(vector<vector<int>>& board) {
        // int ans = 0;
        
        vector<vector<int>> ans;
        for(int row=0;row<board.size();row++){
            for(int col=0;col<board[row].size();col++){
                // ans += findans(board,row,col);
                int val = 0;
                for(int i=0;i<8;i++){
                    int newrow = row + dy[i];
                    int newcol = col + dx[i];
                    
                    if(newrow >= 0 and newrow < board.size() and newcol >= 0 and newcol < board[row].size())val += board[newrow][newcol];
                }
                
                if((val < 2 or val > 3) and board[row][col]==1)ans.push_back({row,col,0});
                else if(val == 3 and board[row][col]==0)ans.push_back({row,col,1});
                // else 
            }
        }
        
        for(auto child:ans){
            board[child[0]][child[1]] = child[2];
        }
        
    }
};