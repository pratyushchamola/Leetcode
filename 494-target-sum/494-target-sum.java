class Solution {
    public int ans;
    public void solve(int[] nums,int curind,int target){
        if(curind == 0){
            if(target == 0){
                ans++;
            }
            return;
        }
        
        if(curind < 0)return;
        
        // if(target == 0)ans++;
        
        solve(nums,curind-1,target-nums[curind-1]);
        solve(nums,curind-1,target+nums[curind-1]);
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        solve(nums,nums.length,target);
        return ans;
    }
}