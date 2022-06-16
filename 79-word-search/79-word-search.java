class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        
        
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0 ; j < n ; j++ ){
                    if(board[i][j] == word.charAt(0) && search(board,m,n,i,j,word,0))
                        return true;
        }
            
       
    }
        return false;
}
        
    public boolean search(char[][] board,int m,int n,int row,int col,String word,int pos){
        if(row < 0 || col < 0 || row >= m || col >= n || pos >= word.length() 
           || board[row][col] != word.charAt(pos) || board[row][col] == '.' )
            return false;
        
        if(pos == word.length() -1 && board[row][col] == word.charAt(pos))
            return true;
        
        char temp = board[row][col];
        board[row][col] = '.';
        
        // left
        boolean left  = search(board,m,n,row,col-1,word,pos+1);
        //right
        boolean right  = search(board,m,n,row,col+1,word,pos+1);
        //up
        boolean up  = search(board,m,n,row-1,col,word,pos+1);
        //down
        boolean down  = search(board,m,n,row+1,col,word,pos+1);
        
        
        //backtracking 
        //lets say found next required letter in board[row][col] , but further letters not present from that cell
        //and we marked that cell visited
        //and correct path goes from that cell then it will take it as visited wont proceed.
        board[row][col] = temp;
        
        return left || right || up || down;
        
    }
        
        
}