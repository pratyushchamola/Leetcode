class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] isTrusted = new int[n+1];
        int[] trustsother = new int[n+1];
        
        for(int i=0;i<trust.length;i++){
            int a = trust[i][0];
            int b = trust[i][1];
            
            trustsother[a]++;
            isTrusted[b]++;
        }
        
        for(int i=1;i<=n;i++){
            if(trustsother[i] == 0 && isTrusted[i] == (n-1))return i;
        }
        
        return -1;
    }
}