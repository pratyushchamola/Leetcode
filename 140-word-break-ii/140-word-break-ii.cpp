class Solution {
public:
    // vector<string> ans;
    void findans(string s,vector<string>& wordDict,int strind,string curans,vector<string>& ans){
        if(strind == s.length()){
            ans.push_back(curans);
            return;
        }
        
        string curstr = "";
        for(int i=strind;i<s.length();i++){
            curstr += s[i];
            auto it = find(wordDict.begin(),wordDict.end(),curstr);
            
            if(it != wordDict.end()){
                findans(s,wordDict,i+1,curans + " " + curstr,ans);
            }
        }
    }
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        vector<string> ans;
        int n = s.length();
        string curstr = "";
        for(int i=0;i<n;i++){
            curstr += s[i];
            auto it = find(wordDict.begin(),wordDict.end(),curstr);
            
            if(it != wordDict.end()){
                findans(s,wordDict,i+1,curstr,ans);
            }
        }
        
        return ans;
    }
};