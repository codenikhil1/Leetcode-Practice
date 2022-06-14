class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        
        if(grid[sr][sc] == color) return grid;
        
        int m = grid.length;
        int n = grid[0].length;
        int startColor = grid[sr][sc];
        dfs(grid,m,n,sr,sc,color,startColor);
                  
        
        return grid;
    }
    
    public void dfs(int[][] grid,int m,int n,int i,int j,int color,int startColor){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != startColor){
            return;
        }
        
        
        grid[i][j] = color;
        
        // move left
        dfs(grid,m,n,i,j-1,color,startColor);
        //move left
        dfs(grid,m,n,i,j+1,color,startColor);
        //move down
        dfs(grid,m,n,i+1,j,color,startColor);
        //move up
        dfs(grid,m,n,i-1,j,color,startColor);
        
        return;
    }
}