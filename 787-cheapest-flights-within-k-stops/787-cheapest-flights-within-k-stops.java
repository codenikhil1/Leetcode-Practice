class Solution {
    //using bellmon-ford algo
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      int cost[] = new int[n];
      Arrays.fill(cost,Integer.MAX_VALUE);
    
      cost[src] = 0;
        
      //relax the edges k+1 times
      
      for(int i = 0 ; i <= k ; i++ ){
          
        //use temp array
        //why we use temp array - https://www.youtube.com/watch?v=5eIK3zUdYmE
        int[] temp = Arrays.copyOf(cost,n);
          
        for(int[] edge : flights){
            int source = edge[0];
            int dest = edge[1];
            int price = edge[2];
            
            if(cost[source] != Integer.MAX_VALUE)
                temp[dest] = Math.min(temp[dest],cost[source]+price);
        }
          
        cost = temp;
      }
        
      return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
        
    }
}