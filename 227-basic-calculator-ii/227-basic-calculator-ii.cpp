class Solution {
public:
    int calculate(string s) {
        
        int ans = 0;
        
        stack<int> st;
        int n = s.size();
        int num = 0;
        char sign = '+';
        
        for(int i=0;i<n;i++){
            // if(s[i] == ' ')continue;
            if(s[i] >= '0' and s[i] <= '9')num = num*10 + (s[i] - '0');
            
            if((s[i] == '*') or (s[i] == '/') or (s[i] == '+') or (s[i] == '-') or (i == n-1)){
                if(sign == '+'){
                    st.push(num);
                }
                if(sign == '-'){
                    st.push(-num);
                }
                if(sign == '*'){
                    int cur = st.top();
                    st.pop();
                    st.push(cur*num);
                }
                if(sign == '/'){
                    int cur = st.top();
                    st.pop();
                    st.push(cur/num);
                }
                
                sign = s[i];
                num = 0;
            }
        }
        
        int toret = 0;
        while(!st.empty()){
            toret += st.top();
            st.pop();
        }
        
        return toret;
    }
};