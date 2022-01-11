// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution{
    public:
    vector<string> values = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    string colName (long long int n)
    {
        string s = "";
        while(n){
            n--;
            int modn = n%26;
            
            // cout << modn << " ";
            s = values[modn] + s;
            
            // cout << n << " ";
            n /= 26;
        }
        // cout << endl;
        return s;
    }
};

// { Driver Code Starts.
int main()
{
    int t; cin >> t;
    while (t--)
	{
		long long int n; cin >> n;
		Solution ob;
		cout << ob.colName (n) << '\n';
	}
}
  // } Driver Code Ends