// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> ans;
    
    public static boolean[][] visited;
    public static void dfs(int currow,int curcol,String curans,int[][] arr,int n){
        if(currow < 0 || curcol < 0 || currow >= n || curcol >= n || arr[currow][curcol] == 0 || visited[currow][curcol] == true)return;
        
        if(currow == n-1 && curcol == n-1){
            ans.add(curans);
            return;
        }
        
        
        visited[currow][curcol] = true;
        
        dfs(currow+1,curcol,curans + 'D',arr,n);
        dfs(currow-1,curcol,curans + 'U',arr,n);
        dfs(currow,curcol+1,curans + 'R',arr,n);
        dfs(currow,curcol-1,curans + 'L',arr,n);
        
        visited[currow][curcol] = false;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ans = new ArrayList<String>();
        visited = new boolean[n][n];
        
        String cur = "";
        dfs(0,0,cur,m,n);
        
        // if(ans.size() == 0)return -1;
        return ans;
        
    }
}