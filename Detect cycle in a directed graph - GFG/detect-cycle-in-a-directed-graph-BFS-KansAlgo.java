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
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        
        
        for(int currentVertex = 0 ; currentVertex < V ; currentVertex++){
            
            for(int currentNeigh : adj.get(currentVertex))
                inDegree[currentNeigh] += 1 ; 
        }
        
        for(int i =  0 ; i < V ; i++ ){
            if(inDegree[i] == 0)
                queue.add(i);
        }
        
        return kansAlgo(queue,V,adj,visited,inDegree);
    }
    
    /*
    Kans Algo - 
        1.Calculate inDegree of all vertexs.
        2.Add element in queue, whos inDegree in zero.
        3.Remove vertex from queue.
        4.If that element is visited then skip steps 4 to 7.
        5.Interate over neighboures of that queue.
        6.reduce inDegree of each element by 1 and if inDegree becomes 0 then add that element to the queue.
        7.repeat step 3 to 6.
        
        8.check if there is a unVisited elements ? if so,then return true.
    
    
    */
    
    public boolean kansAlgo(Queue<Integer> queue,int V, ArrayList<ArrayList<Integer>> adj,
    boolean visited[],int[] inDegree){
        
        int visitedCount =  0 ;
        while(!queue.isEmpty()){
            
            int currentVertex = queue.remove();
            
            if(visited[currentVertex]) continue;
            
            visited[currentVertex] = true;
            visitedCount += 1;
            
            for(int neighbours : adj.get(currentVertex)){
                
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0)
                    queue.add(neighbours);
            }
            
        }
        
        
            
    return !(visitedCount == V);
        
    }
}









