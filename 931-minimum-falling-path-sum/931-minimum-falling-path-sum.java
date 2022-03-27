class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 10000;
        Integer dp[][] = new Integer[m+1][n+1];
        for(int i=0 ; i< n;i++){
            int temp = minPathSum(0,i,m,n,matrix,dp);
            ans = Math.min(ans,temp);
        }
        return ans;
    }
    
    private int minPathSum(int row,int col,int m,int n, int[][] matrix,Integer[][] dp){
        if(row < 0 || col <0 || row >= m || col >= n) return 10000;
        
        if(row == m-1) 
            return matrix[row][col];
        
        if(dp[row][col] != null) return dp[row][col];
        
        int below = matrix[row][col]+minPathSum(row+1,col,m,n,matrix,dp);
        int left = matrix[row][col]+minPathSum(row+1,col-1,m,n,matrix,dp);
        int right = matrix[row][col]+minPathSum(row+1,col+1,m,n,matrix,dp);
        
        dp[row][col] = Math.min(below,Math.min(left,right)); 
        
        return dp[row][col];
        
        
        
    }
}