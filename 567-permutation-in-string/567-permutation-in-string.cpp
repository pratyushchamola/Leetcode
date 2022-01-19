class Solution {
public:
    bool checkInclusion(string s1, string s2) {\
        
        if(s1.length() > s2.length())return false;
                                               
        vector<int> checkcnt(26,0), s2cnt(26,0);
        
        for(int i=0;i<s1.length();i++)checkcnt[s1[i] - 'a']++;
        
        for(int i=0;i<s2.length();i++){
            s2cnt[s2[i] - 'a']++;
            
            if(i >= s1.length())s2cnt[s2[i - s1.length()] - 'a']--;
            
            if(s2cnt == checkcnt)return true;
        }
        
        return false;
    }
};