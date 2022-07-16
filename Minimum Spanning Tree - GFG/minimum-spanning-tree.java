// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static class Pair implements Comparable<Pair>{
        int val;
        int to;
        Pair(int val,int to){
            this.val = val;
            this.to = to;
        }
        
        public int compareTo(Pair that){
            return this.val - that.val;
        }
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        q.add(new Pair(0,0));
        int ans = 0;
        while(q.size() != 0){
            Pair cur = q.remove();
            
            if(vis[cur.to] == true)continue;
            vis[cur.to] = true;
            
            ans += cur.val;
            ArrayList<ArrayList<Integer>> curarr = adj.get(cur.to);
            for(ArrayList<Integer> edge:curarr){
                int ver = edge.get(0);
                int val = edge.get(1);
                
                if(vis[ver] == false){
                    q.add(new Pair(val,ver));
                }
            }
        }
        return ans;
        
    }
}
