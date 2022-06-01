class Solution {
public:
    
    void clearvis(vector<vector<bool>>& vis){
        for(int i=0;i<vis.size();i++){
            for(int j=0;j<vis[i].size();j++){
                vis[i][j] = false;
            }
        }
    }
    
    int dy[4] = {0,-1,0,1};
    int dx[4] = {1,0,-1,0};
    
    bool findans(vector<vector<char>>& arr,string word,int row,int col,int ch,vector<vector<bool>>& visited){
        if(ch >= word.length())return true;
        
        if(row < 0 || col < 0 || row >= arr.size() || col >= arr[0].size() || visited[row][col]==true)return false;
        
        
        if(arr[row][col] != word[ch])return false;
        
        visited[row][col] = true;
        
        bool temp = false;
        
        for(int i=0;i<4;i++){
            int newrow = row + dy[i];
            int newcol = col + dx[i];
            
            temp = temp || findans(arr,word,newrow,newcol,ch+1,visited);
        }
        
        visited[row][col] = false;
        
        return temp;
        
    }
    bool exist(vector<vector<char>>& board, string word) {
        vector<vector<bool>> visited(20,vector<bool>(20,false));
        
        bool ans = false;
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[i].size();j++){
                if(board[i][j] == word[0]){
                    ans = ans || findans(board,word,i,j,0,visited);
                    
                    clearvis(visited);
                }
            }
        }
        
        return ans;
    }
};