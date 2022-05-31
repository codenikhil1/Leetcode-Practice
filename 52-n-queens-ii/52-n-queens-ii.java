class Solution {
    public int totalNQueens(int n) {
        char[][] grid = new char[n][n];
        
        for(int currentRow = 0; currentRow < n; currentRow++){
            for(int currentCol = 0; currentCol < n; currentCol++){
                grid[currentRow][currentCol] = '.';
            }
        }
        
        int[] answer = new int[]{0};
        
        nQueens(grid, 0, n, answer);
        
        return answer[0]; // return answer.size() for N Queens 2
        
    }
    
    private void nQueens(char[][] grid, int currentRow, int n,int[] answer){
        if(currentRow == n){
            answer[0]++;
            return;
        }
        
        for(int currentCol = 0; currentCol < n; currentCol++){
            if(isValid(grid, currentRow, currentCol, n)){
                grid[currentRow][currentCol] = 'Q';
                nQueens(grid, currentRow + 1, n, answer);
                grid[currentRow][currentCol] = '.';
            }
        }
        
    }
    
    private boolean isValid(char[][] grid, int currentRow, int currentCol, int n){
        return isRowValid(grid, currentRow, n) &&
            isColValid(grid, currentCol, n) &&
            areDiagonalsValid(grid, currentRow, currentCol, n);
    }
    
    private boolean isRowValid(char[][] grid, int currentRow, int n){
        
        for(int j=0; j < n; j++){
            if(grid[currentRow][j] == 'Q'){
                return false;
            }
        }
        
        return true;
        
    }
    
    private boolean isColValid(char[][] grid, int currentCol, int n){
        
        for(int i=0; i < n; i++){
            if(grid[i][currentCol] == 'Q'){
                return false;
            }
        }
        
        return true;
        
    }
    
    private boolean areDiagonalsValid(char[][] grid, int currentRow, int currentCol, int n){
        
        
        //we dont need to check lower diagonals
        
        //upper left-diagonal
        int i = currentRow;
        int j = currentCol;
        
        while(i >= 0 && j >= 0){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i -= 1;
            j -= 1;
        }
        
        
        //upper right diagonal
        i = currentRow;
        j = currentCol;
        
        while(i >= 0 && j < n){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i -= 1;
            j += 1;
        }
       
        return true;
    }
    
    
}