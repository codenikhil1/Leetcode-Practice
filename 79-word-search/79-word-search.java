class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        
        
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0 ; j < n ; j++ ){
                boolean visited[][] = new boolean[m][n];
                    if(search(board,m,n,i,j,word,0,visited))
                        return true;
        }
            
       
    }
        return false;
}
        
    public boolean search(char[][] board,int m,int n,int row,int col,String word,int pos,boolean[][] visited){
        if(row < 0 || col < 0 || row >= m || col >= n || pos >= word.length() 
           || board[row][col] != word.charAt(pos) || visited[row][col] == true )
            return false;
        
        if(pos == word.length() -1 && board[row][col] == word.charAt(pos))
            return true;
        
        visited[row][col] = true;
        
        // left
        boolean left  = search(board,m,n,row,col-1,word,pos+1,visited);
        //right
        boolean right  = search(board,m,n,row,col+1,word,pos+1,visited);
        //up
        boolean up  = search(board,m,n,row-1,col,word,pos+1,visited);
        //down
        boolean down  = search(board,m,n,row+1,col,word,pos+1,visited);
        
        visited[row][col] = false;
        
        return left || right || up || down;
        
    }
        
        
}