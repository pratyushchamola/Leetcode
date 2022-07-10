class Solution {
    public int[] parent;
    public int[] size;
    public int[] rank;
    
    public int findParent(int node){
        if(parent[node] == node)return node;
        else return parent[node] = findParent(parent[node]);
    }
    
    public void union(int nodea,int nodeb){
        int para = findParent(nodea);
        int parb = findParent(nodeb);
        
        if(para == parb){
            return;
        }
        
        if(rank[para] >= rank[parb]){
            size[para]++;
            rank[para]++;
            parent[parb] = para;
        }else{
            size[parb]++;
            rank[parb]++;
            parent[para] = parb;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int edgecnt = connections.length;
        
        if(edgecnt < n-1)return -1;
        
        parent = new int[n];
        size = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++)parent[i] = i;
        
        for(int i=0;i<edgecnt;i++){
            union(connections[i][0],connections[i][1]);
        }
        
        Set<Integer> s = new HashSet<Integer>();
        
        for(int i=0;i<n;i++){
            s.add(findParent(i));
        }
        
        return s.size() - 1;
        
    }
}