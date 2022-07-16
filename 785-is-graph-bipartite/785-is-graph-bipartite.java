class Solution {
    

    
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int colors[] = new int[n];
        Arrays.fill(colors,-1);
        
        for(int currentVertex = 0 ; currentVertex < n ; currentVertex++ ){
            
            if(colors[currentVertex] != -1)
                continue;
            
            //dfs
            if(!hasEvenCycle(graph,currentVertex,colors,0))
                return false;
            
            
        }
        
        return true;
       
    }
    
    public boolean hasEvenCycle(int[][] graph,int currentVertex,int[] colors,int currentColor){
        
        if(colors[currentVertex] != -1)
            return colors[currentVertex] == currentColor;
        
        colors[currentVertex] = currentColor;
        
        for(int neigh : graph[currentVertex]){
            
            //dfs
            // 1-currentColor will toggle color 0-1
            if(!hasEvenCycle(graph,neigh,colors,1-currentColor))
                return false;
        }
        
        return true;    
    }
}