class Solution {
    public int closedIsland(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
        
       int ans = 0;
       for(int i = 0 ; i < m ; i++ ){
           for(int j = 0 ; j < n ; j++ ){
               if(grid[i][j] == 0){
                   if(dfs(grid,m,n,i,j)){
                       ans++;
                   }
               }
           }
       }
        
        return ans;    
    }
    
    public boolean dfs(int[][] grid,int m,int n,int row,int col){
        if(row >= m || col >= n || row < 0 || col < 0 ) return false;
        
        if(grid[row][col] == 1 || grid[row][col] == -1)
            return true;
        
        
        grid[row][col] = -1;
        
        //left
        boolean left = dfs(grid,m,n,row,col-1);
        //right
        boolean right = dfs(grid,m,n,row,col+1);
        //up
        boolean up = dfs(grid,m,n,row-1,col);
        //down
        boolean down = dfs(grid,m,n,row+1,col);
        
        return left&&right&&up&&down;
        
        
        
        }
    
    
    
}