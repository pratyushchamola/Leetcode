class Solution {
    public int[][][] dp;
    public int findans(int[] boxes,int i,int j,int cnt){
        if(i>j)return 0;
        
        if(dp[i][j][cnt] != -1)return dp[i][j][cnt];
        
        int curcnt = cnt;
        int init_i = i;
        while(i+1<=j && boxes[i] == boxes[i+1]){
            i++;
            cnt++;
        }
        
        int curans = (cnt+1)*(cnt+1) + findans(boxes,i+1,j,0);
        
        for(int k=i+1;k<=j;k++){
            if(boxes[k] == boxes[i]){
                curans = Math.max(curans,findans(boxes,i+1,k-1,0) + findans(boxes,k,j,cnt+1));
            }
        }
        
        return dp[init_i][j][curcnt] = curans;
        
    }
    public int removeBoxes(int[] boxes) {
        dp = new int[100][100][100];
        
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return findans(boxes,0,boxes.length-1,0);
    }
}