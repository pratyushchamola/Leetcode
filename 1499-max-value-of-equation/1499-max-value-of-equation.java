class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> (a.getKey() == b.getKey() ? a.getValue() - b.getValue() : b.getKey() - a.getKey()));
        
        // yj + xj + (yi - xi)
        int ans = Integer.MIN_VALUE;
        for(int[] child:points){
            while(!pq.isEmpty() && child[0] - pq.peek().getValue() > k)pq.poll();
            
            if(!pq.isEmpty()){
                ans = Math.max(ans,pq.peek().getKey() + child[0] + child[1]);
            }
            pq.offer(new Pair<>(child[1] - child[0],child[0]));
        }
        
        return ans;
    }
}