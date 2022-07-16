class Pair{
    
    int vertex;
    int color;
    
    Pair(int vertex,int color){
        this.vertex = vertex;
        this.color = color;
    }
}
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        ArrayList<ArrayList<Integer>> graph = constructGraph(n,dislikes);
        //maintain color of each vertex either 0 or 1;
        int colors[] = new int[n+1];
        Arrays.fill(colors,-1);
        
        
        //go through each vertex
        for(int currentVertex = 1 ; currentVertex <= n ; currentVertex++ ){
            
            //if vertex is already colored then continue
            if(colors[currentVertex] != -1)
                continue;
            
            //our logic here
            //dfs on each vertex 
            if(!hasEvenCycle(graph,currentVertex,colors,0))
                return false;
            
            
        }
        
        return true;
       
    }
    
    public ArrayList<ArrayList<Integer>> constructGraph(int n , int[][] dislikes){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i <= n ; i++ ){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : dislikes){
            int src = edge[0];
            int dest = edge[1];
            
            graph.get(src).add(dest);
            graph.get(dest).add(src);
            
        }
        
        return graph;
    }
    
    public boolean hasEvenCycleUsingBFS(int[][] graph,int currentVertex,int[] colors,int currentColor){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(currentVertex,0));
        
        while(!queue.isEmpty()){
            Pair currentPair = queue.remove();
            int vertex = currentPair.vertex;
            int color = currentPair.color;
            
            if(colors[vertex] != -1){
                
                if(colors[vertex] != color) 
                    return false;
                
            }else{
                
                colors[vertex] = color;
                
                for(int neigh : graph[vertex]){
                    queue.add(new Pair(neigh,1-color));
                }
            }
            
            
        }
        
        return true;
    }
    
    public boolean hasEvenCycle(ArrayList<ArrayList<Integer>> graph,int currentVertex,int[] colors,int currentColor){
        
        //if vertex is already colored
        //if color is not a color that we were expecting means if other vertex which is connected to this vertex
        //has 0 then this should have 1
        // if thats not case then return false
        if(colors[currentVertex] != -1)
            return colors[currentVertex] == currentColor;
        
        //color the vetex
        colors[currentVertex] = currentColor;
        
        for(int neigh : graph.get(currentVertex)){
            
            //dfs
            // 1-currentColor will toggle color 0-1
            //call recursiverly with neighbour toggling the color
            if(!hasEvenCycle(graph,neigh,colors,1-currentColor))
                return false;
        }
        
        return true;    
    }
}