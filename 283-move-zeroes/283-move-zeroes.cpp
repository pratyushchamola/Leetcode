class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        vector<int> arr;
        int cnt = 0;
        
        for(int i=0;i<nums.size();i++){
            if(nums[i] != 0)arr.push_back(nums[i]);
            else cnt++;
        }
        
        for(int i=0;i<cnt;i++)arr.push_back(0);
        
        // return arr;
        for(int i=0;i<nums.size();i++)nums[i] = arr[i];
    }
};