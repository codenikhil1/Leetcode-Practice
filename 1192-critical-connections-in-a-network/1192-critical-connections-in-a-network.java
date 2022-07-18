class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        // Prepare the adjaceny list from the given edges 
        ArrayList<ArrayList<Integer>> adjList = createConnections(n, connections);
        
        // Stores critical edges/answer
        List<List<Integer>> ans = new ArrayList();
        
        // Stores discovery time and minimum discovery time of each node in the graph
        int[] disc = new int[n];
        int[] low = new int[n];
        
        // Running timer, starts from 1.
        int[] time = new int[] { 1 };
        
        // DFS from 0th node, since there is no parent, set parent to -1.
        dfs(0, -1, adjList, disc, low, time, ans);
        
        return ans;
    }
    
    // Targen's Algorithum
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjList, int[] disc, int[] low, 
                     int[] time, List<List<Integer>> ans) {

        // Set minimum discovery time and discovery time to current time
        low[node] = disc[node] = time[0]++;
        
        for(int adj : adjList.get(node)) {
            // Skip if the adjacent node is the parent
            if( adj == parent ) 
                continue;
            
            // If adjacent node is not yet visited, DFS on the adjacent node
            if( disc[adj] == 0 ) 
                dfs(adj, node, adjList, disc, low, time, ans);
            
            /* If adjacent node can be discovered early than the current node, 
            than update the minimum discovery time of current node as well */
            low[node] = Math.min(low[node], low[adj]);
        }
        
        /* If current node can only be disovered from the parent node, than the
        parent to current node's edge is critical edge (bridge) */
        if( parent != -1 && low[node] > disc[parent] ) 
            ans.add( new ArrayList() {{ add(parent); add(node); }});
    }
    
    private ArrayList<ArrayList<Integer>> createConnections(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        
        for(int i=0; i<n; i++)
            adjList.add( new ArrayList() );
        
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get( u ).add( v );
            adjList.get( v ).add( u );
        }
        
        return adjList;
    }
}