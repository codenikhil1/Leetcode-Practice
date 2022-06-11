class Solution {
    public int findJudge(int n, int[][] trusts) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        
        for(int[] trust : trusts){
            int a = trust[0];
            int b = trust[1];
            
            inDegree[b] += 1;
            outDegree[a] += 1;
        }
        
        for(int i = 1 ; i <= n ; i++ ){
            if(inDegree[i] == n-1 && outDegree[i] == 0)
                return i;
        }
        
        return -1;
        
        
        }
}
