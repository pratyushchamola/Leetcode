class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int sum = 0, ans = 0;
        map<int,int> mp;
        mp[sum] = 1;
        
        for(auto child:nums){
            sum += child;
            int cur = sum - k;
            
            if(mp[cur])ans += mp[cur];
            mp[sum]++;
        }
        
        return ans;
    }
};