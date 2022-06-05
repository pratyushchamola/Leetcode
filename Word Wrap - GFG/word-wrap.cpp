// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

#define ll int

class Solution {
public:

ll findsol(vector<ll> arr, int ind, int k, vector<ll>& dp) {
    if (ind >= arr.size())return 0;
    
    if(dp[ind] != -1)return dp[ind];

    int ans = INT_MAX;
    bool flag = false;
    int curval = k;
    for (int i = ind; i < arr.size(); i++) {
        if (flag)curval -= 1;
        curval -= arr[i];
        flag = true;
        if (curval < 0)break;

        if (i == arr.size() - 1)curval = 0;
        ans = min(ans, findsol(arr, i + 1, k, dp) + curval * curval);
    }

    return dp[ind] = ans;
}


    int solveWordWrap(vector<int>nums, int k) 
    { 
        // Code here
        vector<ll> dp(510,-1);
        ll ans = findsol(nums, 0, k, dp);
        
        return ans;
    } 
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, k;
        cin >> n;
        vector<int>nums(n);
        for (int i = 0; i < n; i++)cin >> nums[i];
        cin >> k;
        Solution obj;
        cout << obj.solveWordWrap(nums, k) << endl;
	}
	return 0;
}  // } Driver Code Ends