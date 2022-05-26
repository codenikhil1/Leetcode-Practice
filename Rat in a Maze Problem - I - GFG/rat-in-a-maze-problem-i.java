// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] grid, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        findRat(grid,n,0,0,"",ans);
        return ans;
    }
    
    private static void findRat(int[][] grid,int n, int row,int col,String currentPath,ArrayList<String> ans){
        
        if(row < 0 || col < 0 || row >= n || col >=n || grid[row][col] == 0 || grid[row][col] == -1 ){
            return;
        }
        
        if(row == n-1 && col == n-1){
            ans.add(currentPath);
        }
    
       grid[row][col] = -1;
       
       // down
       findRat(grid,n,row+1,col,currentPath+"D",ans);
       //UP
       findRat(grid,n,row-1,col,currentPath+"U",ans);
       //left
       findRat(grid,n,row,col-1,currentPath+"L",ans);
       //right
       findRat(grid,n,row,col+1,currentPath+"R",ans);
       
       grid[row][col] = 1;
       
       return;
       
    }
}