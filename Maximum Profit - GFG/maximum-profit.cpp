// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int maxProfit(int K, int N, int A[]) {
        // code here
        int dp[N+1][2][K+1];
        
        for(int d = N-1;d>=0;d--){
            for(int transc = 0;transc <= K;transc++){
                if(d == N-1){
                    dp[d][0][transc] = 0;
                    dp[d][1][transc] = (transc >= 1) ? A[d] : 0;
                }else{
                    dp[d][0][transc] = max((-A[d] + dp[d+1][1][transc]),dp[d+1][0][transc]);
                    dp[d][1][transc] = max(((transc >= 1) ? (A[d] + dp[d+1][0][transc-1]): 0),dp[d+1][1][transc]);
                }
            }
        }
        
        return dp[0][0][K];
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        cin >> K;
        cin >> N;
        int A[N];
        for (int i = 0; i < N; i++) cin >> A[i];

        Solution ob;
        cout << ob.maxProfit(K, N, A) << endl;
    }
    return 0;
}  // } Driver Code Ends