// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
  public:
    int  sum = 0;
    int ans = INT_MAX;
    int maxn = 0;
    int findmindiff(int grid[],int curind,int cursum,vector<vector<int>>& dp){
        if(curind < 0 ){
            // ans = min(ans,abs(sum - 2*cursum));
            return abs(sum - 2*cursum); 
        }
        
        if(dp[curind][cursum] != -1)return dp[curind][cursum];
        
        return dp[curind][cursum]= min(findmindiff(grid,curind-1,cursum + grid[curind-1],dp),findmindiff(grid,curind-1,cursum,dp));
    }
	int minDifference(int arr[], int n)  { 
	    // Your code goes here
	    for(int i=0;i<n;i++){
	        sum += arr[i];
	    }
	   
	    vector<vector<int>> dp(n+1,vector<int>(sum+1,-1));
	    maxn = n;
	    return findmindiff(arr,n,0, dp);
	    
	   // int dp[n+1][sum+1] = {{0}};
	    
	   // for(int i=0;i<n;i++){
	        
	   // }
	    
	   // return ans;
	} 
};


// { Driver Code Starts.
int main() 
{
   
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.minDifference(a, n) << "\n";
	     
    }
    return 0;
}  // } Driver Code Ends