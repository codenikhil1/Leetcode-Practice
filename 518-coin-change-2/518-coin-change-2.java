class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        
        Integer dp[][] = new Integer[len][amount+1];
        return change(amount,coins,0,len,dp);
    }
    
    private int change(int amt,int[] coins,int cur,int n,Integer[][] dp){
        if(cur >= n ) return 0;
        
        if(amt == 0) return 1;
        
        if(dp[cur][amt] != null) return dp[cur][amt];
        
        int currentAmt = coins[cur];
        int consider = 0;
        if(amt - currentAmt >= 0)
            consider =  change(amt-currentAmt,coins,cur,n,dp);
        int dontConsider = change(amt,coins,cur+1,n,dp);
        
        dp[cur][amt] = consider+dontConsider; 
        return dp[cur][amt];
        
        
        
    }
}