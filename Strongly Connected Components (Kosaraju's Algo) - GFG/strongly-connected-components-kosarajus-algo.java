// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public Stack<Integer> st;
    public int[] visited;
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int node){
        visited[node] = 1;
        
        for(int child:adj.get(node)){
            if(visited[child] == 1)continue;
            dfs(adj,child);
        }
        
        st.add(node);
    }
    
    public void revdfs(ArrayList<ArrayList<Integer>> adj,int node){
        visited[node] = 1;
        
        for(int child:adj.get(node)){
            if(visited[child] == 1)continue;
            dfs(adj,child);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        st = new Stack<Integer>();
        visited = new int[V];
        ArrayList<ArrayList<Integer>> revarr = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++){
            revarr.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++){
            if(visited[i] == 1)continue;
            dfs(adj,i);
        }
        
        for(int i=0;i<V;i++){
            visited[i] = 0;
            for(int j:adj.get(i)){
                revarr.get(j).add(i);
            }
        }
        
        int ans = 0;
        while(st.isEmpty() == false){
            int cur = st.peek();
            st.pop();
            
            if(visited[cur] == 0){
                ans++;
                revdfs(revarr,cur);
            }
        }
        
        return ans;
        
    }
}
