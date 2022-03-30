class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int low = 0, high = nums.size()-1;
        
        bool flag = false;
        while(high>=low){
            while((high > low) and nums[high] == nums[high-1])high--;
            while((high > low) and nums[low] == nums[low+1])low++;
            
            int mid = (high+low)>>1;
            
            if(nums[mid] == target){
                return true;
            }else{
                if(nums[low] <= nums[mid]){
                    if(nums[low]<=target and target<=nums[mid]){
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }
                }else{
                    if(nums[mid]<=target and target<=nums[high]){
                        low = mid+1;
                    }else high = mid-1;
                }
            }
        }
        
        
        return false; 
    }
};