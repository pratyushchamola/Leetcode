class Solution {
    public int deleteAndEarn(int[] nums) {
        HashSet<Integer> ch = new HashSet<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int cur:nums){
            if(freq.containsKey(cur)){
                freq.put(cur,freq.get(cur)+1);
            }else freq.put(cur,1);
        }
        
        System.out.println(freq);
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            arr.add(entry.getKey());
        }
        
        Collections.sort(arr);
        
        System.out.println(arr);
        return solve(arr,freq);
    }
    
    public int solve(ArrayList<Integer> arr,HashMap<Integer,Integer> freq){
        int prev = arr.get(0)*freq.get(arr.get(0));
        int prevprev = 0;
        
        for(int i=1;i<arr.size();i++){
            int with = arr.get(i)*freq.get(arr.get(i));
            int without = 0;
            if(arr.get(i) - arr.get(i-1) == 1){
                with += prevprev;
                without = prev;
            }else with += prev;
            
            int curans = Math.max(with,without);
            prevprev = prev;
            prev = curans;
        }
        
        return prev;
    }
}