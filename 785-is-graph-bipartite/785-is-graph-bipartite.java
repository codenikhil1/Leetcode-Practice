class Pair{
    
    int vertex;
    int color;
    
    Pair(int vertex,int color){
        this.vertex = vertex;
        this.color = color;
    }
}

class Solution {
    
    
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        //maintain color of each vertex either 0 or 1;
        int colors[] = new int[n];
        Arrays.fill(colors,-1);
        
        
        //go through each vertex
        for(int currentVertex = 0 ; currentVertex < n ; currentVertex++ ){
            
            //if vertex is already colored then continue
            if(colors[currentVertex] != -1)
                continue;
            
            //our logic here
            //dfs on each vertex 
            if(!hasEvenCycleUsingBFS(graph,currentVertex,colors,0))
                return false;
            
            
        }
        
        return true;
       
    }
    
    public boolean hasEvenCycleUsingBFS(int[][] graph,int vertex,int[] colors,int currentColor){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(vertex,0));
        
        while(!queue.isEmpty()){
            Pair currentPair = queue.remove();
            int Currentvertex = currentPair.vertex;
            int color = currentPair.color;
            
            if(colors[Currentvertex] != -1){
                
                if(colors[Currentvertex] != color) 
                    return false;
                
            }else{
                
                colors[Currentvertex] = color;
                
                for(int neigh : graph[Currentvertex]){
                    queue.add(new Pair(neigh,1-color));
                }
            }
            
            
        }
        
        return true;
    }
    
    public boolean hasEvenCycle(int[][] graph,int currentVertex,int[] colors,int currentColor){
        
        //if vertex is already colored
        //if color is not a color that we were expecting means if other vertex which is connected to this vertex
        //has 0 then this should have 1
        // if thats not case then return false
        if(colors[currentVertex] != -1)
            return colors[currentVertex] == currentColor;
        
        //color the vetex
        colors[currentVertex] = currentColor;
        
        for(int neigh : graph[currentVertex]){
            
            //dfs
            // 1-currentColor will toggle color 0-1
            //call recursiverly with neighbour toggling the color
            if(!hasEvenCycle(graph,neigh,colors,1-currentColor))
                return false;
        }
        
        return true;    
    }
}