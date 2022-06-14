class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] visited = new int[m][n];
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,m,n,i,j);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(char[][] grid,int m,int n,int i,int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0'){
            return;
        }
        
        
        grid[i][j] = '0';
        
        // move left
        dfs(grid,m,n,i,j-1);
        //move left
        dfs(grid,m,n,i,j+1);
        //move down
        dfs(grid,m,n,i+1,j);
        //move up
        dfs(grid,m,n,i-1,j);
        
        return;
    }
}