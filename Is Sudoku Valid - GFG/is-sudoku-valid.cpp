// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    
    bool checkrow(vector<vector<int>>& arr,int row){
        int indcnt[10] = {0};
        
        for(int i=0;i<9;i++){
            indcnt[arr[row][i]]++;
        }
        
        for(int i=1;i<=9;i++){
            if(indcnt[i] > 1)return false;
        }
        
        return true;
        
    }
    
    bool checkcol(vector<vector<int>>& arr,int col){
        int indcnt[10] = {0};
        
        for(int i=0;i<9;i++){
            indcnt[arr[i][col]]++;
        }
        
        for(int i=1;i<=9;i++){
            if(indcnt[i] > 1)return false;
        }
        
        return true;
        
    }
    
    bool checksubgrid(int row,int col,vector<vector<int>>& arr){
        int indcnt[10] = {0};
        
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                indcnt[arr[i][j]]++;
            }
        }
        
        for(int i=1;i<=9;i++){
            if(indcnt[i] > 1)return false;
        }
        
        return true;
    }
    
    int isValid(vector<vector<int>> mat){
        // code here
        // cout << "here two "
        for(int i=0;i<9;i++){
            if(!checkrow(mat,i) || !checkcol(mat,i)){
                return false;
            }
        }
        
        // cout << "works till here" << endl;
        for(int i=0;i<9;i += 3){
            for(int j=0;j<9;j += 3){
                if(!checksubgrid(i,j,mat))return false;
            }
        }
        
        return true;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        vector<vector<int>> mat(9, vector<int>(9, 0));
        for(int i = 0;i < 81;i++)
            cin>>mat[i/9][i%9];
        
        Solution ob;
        cout<<ob.isValid(mat)<<"\n";
    }
    return 0;
}  // } Driver Code Ends