class Solution {
    public int maximalSquare(char[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;
       Integer dp[][] = new Integer[m+1][n+1];
       int max = 0;
       for(int i = 0 ; i < m ; i++ ){
           for(int j = 0 ; j < n ;j++){
               int side = max(i,j,m,n,matrix,dp);
               max = Math.max(max,side*side);
           }
       }
        return max;
    }
    
    private int max(int currentRow , int currentCol , int m ,int n , char[][] matrix,Integer dp[][]){
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n)
            return 0;
        if(matrix[currentRow][currentCol] == '0') return 0;
        
        if(dp[currentRow][currentCol] != null) return dp[currentRow][currentCol];
        
        int front =    1+max(currentRow,currentCol+1,m,n,matrix,dp);
        int down =     1+max(currentRow+1,currentCol,m,n,matrix,dp);
        int diagonal = 1+max(currentRow+1,currentCol+1,m,n,matrix,dp);
        
        dp[currentRow][currentCol] = Math.min(front,Math.min(down,diagonal));
        return dp[currentRow][currentCol];
    }
}