class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n= nums.size();
        
        // if(k > n)
        k = k%n;
        if ((n == 0) || (k <= 0) || n==1)return;
        
        reverse(nums.begin() + nums.size() - k,nums.end());
        reverse(nums.begin(),nums.begin() + nums.size() - k);
        
        reverse(nums.begin(),nums.end());
    }
};