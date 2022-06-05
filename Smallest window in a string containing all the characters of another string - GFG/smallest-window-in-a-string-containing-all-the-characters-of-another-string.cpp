// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    string smallestWindow (string s, string p)
    {
        // Your code here
        
        unordered_map<char,int> mp;
        
        for(auto child:p)mp[child]++;
        
        int cnt = mp.size();
        int str = 0, ed = 0, len = INT_MAX;
        pair<int,int> ans;
        int n = s.size();
        while(ed<n){
            if(mp.find(s[ed]) != mp.end()){
                mp[s[ed]]--;
                
                if(mp[s[ed]] == 0)cnt--;
            }
            
            if(cnt == 0){
                while(cnt == 0){
                    if(ed - str + 1 < len){
                        len = ed - str + 1;
                        ans = {str,len};
                    }
                    
                    if(mp.find(s[str]) != mp.end()){
                        mp[s[str]]++;
                        
                        if(mp[s[str]] == 1){
                            cnt++;
                        }
                    }
                    str++;
                }
            }
            ed++;
        }
        
        return (len == INT_MAX) ? "-1" : s.substr(ans.first,ans.second);
    }
};

// { Driver Code Starts.
int main()
 {
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        string pat;
        cin>>pat;
        Solution obj;
        cout<<obj.smallestWindow(s, pat)<<endl;
        
    }
	return 0;
}  // } Driver Code Ends