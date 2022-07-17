class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<int> prev(n, INT_MAX);
        vector<int> curr(n, INT_MAX);
        
        prev[src] = 0;
        
        for(int i=0; i<k+1; i++){
            for(vector<int> edge : flights){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(prev[u] != INT_MAX and curr[v] > prev[u]+w){
                    curr[v] = prev[u]+w;
                }
            }
            
            prev = curr;
        }
        
        return (curr[dst] == INT_MAX) ? -1 : curr[dst];
    }
};