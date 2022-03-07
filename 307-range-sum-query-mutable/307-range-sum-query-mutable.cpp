class BIT{
    vector<int> bit;
    public:
    BIT(int size=0){
        bit.resize(size+1,0);
    }
    
    int getSum(int ind){
        int sum = 0;
        for(;ind > 0; ind -= ind&(-ind)){
            sum += bit[ind];
        }
        
        return sum;
    }
    
    void addValue(int val,int ind){
        for(;ind < bit.size();ind += ind&(-ind)){
            bit[ind] += val;
        }
    }
};

class NumArray {
    BIT bit;
    vector<int> nums;
public:
    NumArray(vector<int>& nums) {
        this->bit = BIT(nums.size());
        this->nums = nums;
        for(int i=0;i<nums.size();i++){
            bit.addValue(nums[i],i+1);
        }
    }
    
    void update(int index, int val) {
        int diff = val - nums[index];
        bit.addValue(diff,index+1);
        nums[index] = val;
        
    }
    
    int sumRange(int left, int right) {
        return bit.getSum(right+1) - bit.getSum(left);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */