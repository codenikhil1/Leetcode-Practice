// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int capacity, int val[], int wt[])
    {
        // code here
        Integer[][] dp = new Integer[N][capacity+1];
        return knapsackUnbounded(N,capacity,val,wt,0,dp);
    }
    
    static int knapsackUnbounded(int N, int cap,int[] val,
    int wt[],int cur,Integer[][] dp){
        if(cur >= N ) return 0;
        
        if(cap == 0) return 0;
        
        if(dp[cur][cap] != null) return dp[cur][cap];
        
        int currentWeight = wt[cur];
        
        int consider = 0;
        
        if(cap - currentWeight >= 0)
            consider = val[cur] + knapsackUnbounded(N,cap-currentWeight,val,wt,cur,dp);
        int dontConsider = knapsackUnbounded(N,cap,val,wt,cur+1,dp);
        
        dp[cur][cap] = Math.max(consider,dontConsider); 
        return dp[cur][cap];
    }
}