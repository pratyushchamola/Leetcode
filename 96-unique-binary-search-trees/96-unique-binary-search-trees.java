class Solution {
    public Map<Pair<Integer,Integer>,Integer> mp;
    public int findans(int str,int end){
        if(str > end)return 1;
        
        int ans = 0;
        for(int i=str;i<=end;i++){
            int left = 0;
            int right = 0;
            
            if(mp.containsKey(new Pair<Integer,Integer>(str,(i-1))) == true)left = mp.get(new Pair<Integer,Integer>(str,(i-1)));
            else left = findans(str,i-1);
            
            if(mp.containsKey(new Pair<Integer,Integer>(i+1,end)) == true)right = mp.get(new Pair<Integer,Integer>(i+1,end));
            else right = findans(i+1,end);
            
            ans += left*right;
        }
        
        mp.put(new Pair<Integer,Integer>(str,end),ans);
        return ans;
    }
    public int numTrees(int n) {
        mp = new HashMap<Pair<Integer,Integer>,Integer>();
        return findans(1,n);
    }
}