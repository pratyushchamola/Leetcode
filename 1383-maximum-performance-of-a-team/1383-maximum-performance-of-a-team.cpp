// #define ll long long

// const static long long mod = 1e9 + 7;
class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        vector<pair<int,int>> vl(n);
        
        for(int i=0;i<n;i++){
            vl[i] = {efficiency[i],speed[i]};
        }
        
        sort(vl.begin(),vl.end(),greater<pair<int,int>>());
        
        priority_queue<int,vector<int>,greater<int>> pq;
        
        
        
        long ans = 0;
        long sum = 0;
        
        for(int i=0;i<n;i++){
            sum += vl[i].second;
            pq.push(vl[i].second);
            
            if(pq.size() > k){
                sum -= pq.top();
                pq.pop();
            }
            
            // long curmax = ((sum*vl[i].first)%mod + mod)%mod;
            long curmax = sum*vl[i].first;
            ans = max(ans,curmax);
        }
        
        return ans%(int)(1e9+7);
    }
};