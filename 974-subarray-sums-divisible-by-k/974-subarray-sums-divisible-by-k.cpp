class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int presum = 0 , ans = 0;
        map<int,int> mp;
        mp[0] = 1;
        
        for(int i=0;i<nums.size();i++){
            presum = (presum + nums[i]%k + k)%k;
            ans += mp[presum]++;
        }
        
        return ans;
    }
};