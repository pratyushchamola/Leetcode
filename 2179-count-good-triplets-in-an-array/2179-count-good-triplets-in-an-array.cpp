class Solution {
public:
    // fenwick tree or binary indexed tree
//     const int static n = 100000;
//     int bt[n+1] = {};
    
//     int findans(int ind){
//         int sum = 0;
        
//         for(int i=ind+1;i>0;i -= (i & (-i))){
//             sum += bt[i];
//         }
        
//         return sum;
//     }
    
//     void add(int ind,int x){
//         for(int i=ind+1;i<=n;i += (i & (-i))){
//             bt[i] += x;
//         }
//     }
    
//     long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
//         vector<int> index(nums1.size());
//         int sz = nums1.size();
//         for(int i=0;i<sz;i++)index[nums2[i]] = i;
        
//         int ans = 0;
//         for(int i=0;i<sz-1;i++){
//             int mid = index[nums1[i]];
//             int smaller = findans(mid);
//             int larger = sz -1 - mid - (i - smaller);
            
//             ans += (long long)larger*smaller;
//             add(mid,1);
//         }
        
//         return ans;
//     }
    
    constexpr int static n = 100000;
int bt[n + 1] = {};
int prefix_sum(int i) {
    int sum = 0;
    for (i = i + 1; i > 0; i -= i & (-i))
        sum += bt[i];
    return sum;
}
void add(int i, int val) {
    for (i = i + 1; i <= n; i += i & (-i))
        bt[i] += val;
}
long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
    long long res = 0, sz = nums1.size();
    vector<int> ids(sz);
    for (int i = 0; i < sz; ++i)
        ids[nums2[i]] = i;
    for (int i = 0; i < sz - 1; ++i) {
        int mid = ids[nums1[i]], sm = prefix_sum(mid), gr = sz - 1 - mid - (i - sm);
        res += (long long)sm * gr;
        add(mid, 1);
    }
    return res;
}
};