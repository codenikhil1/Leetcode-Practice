class Solution {
    public int findTheCity(int v, int[][] matrix, int distanceThreshold) {
        
        int[][] cost = new int[v][v];
        
        //make cose 2D array put all elements in that 
        
        for(int i = 0 ; i < v ; i++ )
            for(int j = 0 ; j < v ; j++ )
                    cost[i][j] = Integer.MAX_VALUE;
        
        for(int edge[] : matrix){
            int src = edge[0];
            int dest = edge[1];
            int Currentcost = edge[2];
            
            cost[src][dest] = Currentcost;
            cost[dest][src] = Currentcost;
            
        }

        // put min of source->dist,source->intermediate+intermediate->dest
        
        for(int intermediate = 0 ; intermediate < v ; intermediate++ ){
            for(int source = 0 ; source < v ; source++ ){
                for(int dest = 0 ; dest < v ; dest++ ){
                    if( cost[source][intermediate] != Integer.MAX_VALUE && cost[intermediate][dest] != Integer.MAX_VALUE)
                        cost[source][dest] = Math.min(cost[source][dest],
                             cost[source][intermediate] + cost[intermediate][dest]);
                    
                }
                
            }
        }
        
        //calculate no of cities reachable from each city(if dist is greater than threshold then dont consider)
        
        int maxReach = 101;
        int reach = 0;
        int ans = -1;
        
        for(int i = 0 ; i < v ; i++ ){
            reach = 0;
            for(int j = 0 ; j < v ; j++ ){
                if( i!=j && cost[i][j] <= distanceThreshold)
                    reach++;
            }
            
            if(reach <= maxReach ){
                ans = i;
                maxReach = reach;
            }
        }
        
        return ans;
        
        
    }
}