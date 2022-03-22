// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        Integer dp[][] = new Integer[price.length+1][n+1];
        return maxValue(price,n,0,dp);
    }
    
    private int maxValue(int[] prices,int size,int current,Integer[][] dp){
        if(size == 0) return 0;
        
        if(current >= prices.length) return 0;
        
        if(dp[current][size] != null ) return dp[current][size];
        
        int consider = 0;
        int currentValue = prices[current];
        int currentPieceLenght = current+1;
        
        //doing currentIndex +1 here cause
        //index are 0 based but index 0 reprents rod of size 1
        //index  1 represent rode of size 2 
        if(currentPieceLenght <= size)
            consider = currentValue + maxValue(prices,size-currentPieceLenght,current,dp);
            
        int dontConsider = maxValue(prices,size,current+1,dp);
        
        dp[current][size] = Math.max(consider,dontConsider); 
        
        return dp[current][size]; 
        
        
        
    }
}