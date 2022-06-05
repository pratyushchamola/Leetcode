class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<string> arr = strs;
        int n = strs.size();
        for(int i=0;i<n;i++){
            sort(arr[i].begin(),arr[i].end());
        }
        map<string,vector<string>> mp;
        
        for(int i=0;i<n;i++){
            mp[arr[i]].push_back(strs[i]);
        }
        
        vector<vector<string>> ans;
        
        for(auto child:mp){
            ans.push_back(child.second);
        }
        
        return ans;
    }
};