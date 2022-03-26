class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer dp[][] = new Integer[m+1][n+1];
        return ways(m,n,grid,0,0,dp);
    }
    
    private int ways(int m,int n,int[][]  grid,int x, int y,Integer dp[][]){
        if(x >= m || y >= n || grid[x][y] == 1) return 0;
        
        if(x == m-1 && y == n-1 ) return 1;
        
        if(dp[x][y] != null) return dp[x][y];
        
        int right = ways(m,n,grid,x,y+1,dp);
        int down = ways(m,n,grid,x+1,y,dp);
        
        dp[x][y] = right+down;
        
        return right+down;
    }   
}