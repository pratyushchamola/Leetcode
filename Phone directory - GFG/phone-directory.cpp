// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    vector<vector<string>> displayContacts(int n, string contact[], string s)
    {
        // code here
        set<string> q;
        vector<vector<string>> ans(s.size());
        
        for(int i=0;i<n;i++){
            if(contact[i][0] == s[0])q.insert(contact[i]);
        }
        
        if(q.empty()){
            for(int i=0;i<s.size();i++){
                ans[i].push_back("0");
            }
            
            return ans;
        }else{
            for(auto child:q){
                ans[0].push_back(child);
            }
            
            vector<string> curans;
            for(int i=1;i<s.size();i++){
                curans.clear();
                string curstr = s.substr(0,i+1);
                
                for(int curind = 0;curind < ans[i-1].size();curind++){
                    if(ans[i-1][curind].substr(0,i+1) == curstr)curans.push_back(ans[i-1][curind]);
                }
                
                if(curans.size() == 0){
                    while(i < s.size()){
                        ans[i].push_back("0");
                        i++;
                    }
                    
                    return ans;
                }else{
                        // ans[i].push_back(curans);
                        for(string child:curans){
                            ans[i].push_back(child);
                        }
                }
            }
            
            return ans;
            
        }
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        string contact[n], s;
        for(int i = 0;i < n;i++)
            cin>>contact[i];
        cin>>s;
        
        Solution ob;
        vector<vector<string>> ans = ob.displayContacts(n, contact, s);
        for(int i = 0;i < s.size();i++){
            for(auto u: ans[i])
                cout<<u<<" ";
            cout<<"\n";
        }
    }
    return 0;
}  // } Driver Code Ends