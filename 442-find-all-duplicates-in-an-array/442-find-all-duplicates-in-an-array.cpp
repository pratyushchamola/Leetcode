class Solution {
public:
    // vector<int> mp(100002,0);
    vector<int> findDuplicates(vector<int>& nums) {
        
        vector<int> ans;
        
        for(int i=0;i<nums.size();i++){
            nums[abs(nums[i]) - 1] = -nums[abs(nums[i]) -1];
            if(nums[abs(nums[i]) - 1] > 0)ans.push_back(abs(nums[i]));
        }
        
        return ans;
    }
};