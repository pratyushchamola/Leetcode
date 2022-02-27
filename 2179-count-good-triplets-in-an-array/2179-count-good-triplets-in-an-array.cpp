class Solution {
public:
    // fenwick tree or binary indexed tree
    constexpr int static n = 100000;
    int bt[n+1] = {};
    
    int findans(int ind){
        int sum = 0;
        
        for(int i=ind+1;i>0;i -= (i & (-i))){
            sum += bt[i];
        }
        
        return sum;
    }
    
    void add(int ind,int x){
        for(int i=ind+1;i<=n;i += (i & (-i))){
            bt[i] += x;
        }
    }
    
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        vector<int> index(nums1.size());
        long long sz = nums1.size();
        for(int i=0;i<sz;i++)index[nums2[i]] = i;
        
        long long ans = 0;
        for(int i=0;i<sz-1;i++){
            int mid = index[nums1[i]];
            int smaller = findans(mid);
            int larger = sz -1 - mid - (i - smaller);
            
            ans += (long long)larger*smaller;
            add(mid,1);
        }
        
        return ans;
    }

};