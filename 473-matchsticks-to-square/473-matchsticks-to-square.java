class Solution {
    public int size;
    public boolean makesquare(int[] matchsticks) {
        // mp = new HashMap<>();
        if(matchsticks.length < 4)return false;
        int sum = 0;
        for(int child:matchsticks)sum += child;
        
        if(sum%4 != 0)return false;
        int side = sum/4;
        
        size = matchsticks.length;
        Arrays.sort(matchsticks);
        int[] arr = new int[]{side,side,side,side};
        return findans(matchsticks,size,arr);
    }
    
    public boolean findans(int[] box,int ind,int[] arr){
        if(ind == 0)return true;
        
        for(int i=0;i<4;i++){
            if(box[ind-1] > arr[i])continue;
            
            arr[i] -= box[ind-1];
            
            if(findans(box,ind-1,arr) == true)return true;
            arr[i] += box[ind-1];
        }
        
        return false;
    }
}