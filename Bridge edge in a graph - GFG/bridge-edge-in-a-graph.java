// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    public static void dfs(int node,ArrayList<ArrayList<Integer>> arr,int a,int b,int[] visited){
        visited[node] = 1;
        
        for(int child:arr.get(node)){
            if(visited[child] == 0 && ((node != a) || (child != b)))dfs(child,arr,a,b,visited);
        }
    }
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        int[] visited = new int[V];
        
        dfs(c,adj,c,d,visited);
        
        // return (visited[d] == 0) ? 1 : 0;
        return (visited[d]==1) ? 0 : 1;
    }
}