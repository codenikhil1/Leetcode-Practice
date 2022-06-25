class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = constructGraph(numCourses,prerequisites);
        
        int[] inDegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        for(int i = 0 ; i < numCourses ; i++ ){
            for(int vertex : adj.get(i))
                inDegree[vertex]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < numCourses;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
                
        } 
        while(!queue.isEmpty()){
            int course = queue.remove();    
                
            if(visited[course])
                continue;
            
            visited[course] = true;
            ans.add(course);
            
            for(int neigh : adj.get(course)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0)
                    queue.add(neigh);
            }
            
        }
        
        if(ans.size() != numCourses)
            return false;
        
        return true;
        
    }
    
    public ArrayList<ArrayList<Integer>> constructGraph(int n , int[][] prerequisites){
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0 ; i < n ; i++ )
            adj.add(new ArrayList<Integer>());
        
        for(int edge[] : prerequisites ){
            int a = edge[0];
            int b = edge[1];
            // must take course b first if you want to take course a.
            adj.get(b).add(a);
        }
        
        return adj;
    }
}