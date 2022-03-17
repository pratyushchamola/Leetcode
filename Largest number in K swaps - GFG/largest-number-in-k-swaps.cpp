// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


class Solution
{
    public:
    //Function to find the largest number after k swaps.
    void findans(string s,string& ans,int k,int ind){
        if(k == 0)return;
        char c = s[ind];
        
        for(int i=ind+1;i<s.length();i++){
            if(s[i]>c)c = s[i];
        }
        
        if(c != s[ind])k--;
        
        for(int i=0;i<s.length();i++){
            if(s[i] == c){
                swap(s[ind],s[i]);
                ans = max(ans,s);
                findans(s,ans,k,ind+1);
                swap(s[i],s[ind]);
            }
        }
    }
    string findMaximumNum(string str, int k)
    {
       // code here.
       string ans = str;
       findans(str,ans,k,0);
       return ans;
    }
};

// { Driver Code Starts.

int main()
{
    int t, k;
    string str;

    cin >> t;
    while (t--)
    {
        cin >> k >> str;
        Solution ob;
        cout<< ob.findMaximumNum(str, k) << endl;
    }
    return 0;
}
  // } Driver Code Ends