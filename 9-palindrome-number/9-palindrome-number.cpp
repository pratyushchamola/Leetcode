class Solution {
public:
    bool isPalindrome(int x) {
        bool flag = true;
        string s = to_string(x);
        
        int l = 0, r = s.length()-1;
        
        while(l<r){
            if(s[l] != s[r]){
                flag = false;
                break;
            }
            l++;
            r--;
        }
        
        if(flag)return true;
        else return false;
    }
};