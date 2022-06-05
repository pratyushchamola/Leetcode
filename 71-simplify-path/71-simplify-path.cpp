class Solution {
public:
    string simplifyPath(string path) {
        stack<string> st;
        string ans = "";
        for(int i=0;i<path.size();i++){
            if(path[i] == '/'){
                if(ans.size()>2)st.push(ans);
                else if(ans == ".")ans = "";
                else if(ans == ".."){
                    if(!st.empty())st.pop();
                }
                else if(ans.size() != 0) st.push(ans);
                ans = "";
            }else{
                ans += path[i];
            }
        }
        
        if(ans.size()>0){
                if(ans.size()>2)st.push(ans);
                else if(ans == ".")ans = "";
                else if(ans == ".."){
                    if(!st.empty())st.pop();
                }
                else if(ans.size() != 0) st.push(ans);
                ans = "";
        }
        
        // string toret = "";
        vector<string> toret;
        
        while(!st.empty()){
            toret.push_back(st.top());
            st.pop();
        }
        
        reverse(toret.begin(),toret.end());
        
        ans = "";
        for(int i=0;i<toret.size();i++){
            ans += '/';
            ans += toret[i];
        }
        
        // ans += '/';
        
        return ans.size()>0 ? ans : "/";
        
        
    }
};