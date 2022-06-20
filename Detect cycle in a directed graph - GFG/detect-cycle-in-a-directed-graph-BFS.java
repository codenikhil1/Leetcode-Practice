// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
    boolean visited[] = new boolean[V];
    
    int[] VisitedInCurrentComponent = new int[V];
    
    for(int currentVertex = 0 ; currentVertex < V ; currentVertex++ ){
        
        if(!visited[currentVertex]){
            
            if(hasCycle(adj,currentVertex,visited,VisitedInCurrentComponent))
                return true;
        }
    }
    
    return false;
        
        
    }
    
    public boolean hasCycle(ArrayList<ArrayList<Integer>> adj,int currentVertex,
    boolean[] visited,int[] VisitedInCurrentComponent){
        
        visited[currentVertex]  = true;
       
        VisitedInCurrentComponent[currentVertex] =  1;
        
        for(int neighbours : adj.get(currentVertex)){
            
            if(!visited[neighbours]){
                
                if(hasCycle(adj,neighbours,visited,VisitedInCurrentComponent))
                    return true;
            }else if(VisitedInCurrentComponent[neighbours] ==  1)
                return true;
            
        
        }
        VisitedInCurrentComponent[currentVertex] = 0;
        return false;
    }
}








