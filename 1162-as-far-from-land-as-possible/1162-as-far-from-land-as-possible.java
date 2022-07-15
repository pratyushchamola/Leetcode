class Solution {
    public class Pair{
        int row;
        int col;
        // int val;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
            // this.val = val;
        }
    }
    public int[] dx;
    public int[] dy;
    public int maxDistance(int[][] grid) {
        dx = new int[]{0,0,1,-1};
        dy = new int[]{1,-1,0,0};
        
        int n = grid.length;
        int[][] dist = new int[n][n];
        
        
        Queue<Pair> q = new LinkedList<>();
        
        int onecnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
                if(grid[i][j] == 1){
                    onecnt++;
                    q.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
                
            }
        }
        
        
        if(onecnt == 0 || onecnt == (n*n))return -1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            // for(int i=0;i<sz;i++){
                Pair cur = q.poll();
                
                for(int j=0;j<4;j++){
                    int newrow = cur.row + dx[j];
                    int newcol = cur.col + dy[j];
                    
                    if(newrow < 0 || newcol < 0 || newrow >= n || newcol >= n)continue;
                    
                    if(dist[newrow][newcol] > (1 + dist[cur.row][cur.col])){
                        dist[newrow][newcol] = dist[cur.row][cur.col] + 1;
                        q.add(new Pair(newrow,newcol));
                    }
                }
            // }
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0)ans = Math.max(ans,dist[i][j]);
            }
        }
        
        // if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
}