class Solution {
public:
    int subarrayGCD(vector<int>& nums, int k) {
        unordered_map<int,int> global;
        int ans = 0;
        for(int i=0;i<nums.size();i++){
            unordered_map<int,int> local;
            
            if(nums[i]%k == 0){
                local[nums[i]]++;
                for(auto [prev_gcd,cnt] : global){
                    local[gcd(prev_gcd,nums[i])] += cnt;
                }
            }
            
            ans += local[k];
            swap(local,global);
        }
        
        return ans;
    }
};