class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        // vector<string> arr = strs;
        int n = strs.size();
        map<string,vector<string>> mp;
        string t;
        
        for(int i=0;i<n;i++){
            t = strs[i];
            sort(t.begin(),t.end());
            
            mp[t].push_back(strs[i]);
        }
        
        
        vector<vector<string>> ans;
        
        for(auto child:mp){
            ans.push_back(child.second);
        }
        
        return ans;
    }
};