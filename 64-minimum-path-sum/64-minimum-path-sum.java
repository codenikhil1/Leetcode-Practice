class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Integer dp[][] = new Integer[row+1][col+1];
        return minPath(0,0,row,col,grid,dp);
    }
    
    private int minPath(int row,int col,int m,int n,int[][] grid,Integer[][] dp){
        if(row >= m || col >= n) return 1001;
        
        if(row == m-1 && col == n-1) return grid[row][col];
        
        if(dp[row][col] != null ) return dp[row][col];
        
        int right = grid[row][col]+minPath(row,col+1,m,n,grid,dp);
        int down = grid[row][col]+minPath(row+1,col,m,n,grid,dp);
        
        dp[row][col] = Math.min(right,down); 
        
        return dp[row][col];
        
        
    }
}