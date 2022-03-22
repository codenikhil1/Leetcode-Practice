class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        
        Integer dp[][] = new Integer[len+1][amount+1];
        int ans = change(amount,coins,0,len,dp);
        return ans == 10001 ? -1 :ans;
    }
    
    private int change(int amt,int[] coins,int cur,int n,Integer[][] dp){
        if(cur >= n ) return 10001;
        
        if(amt == 0) return 0;
        
        if(dp[cur][amt] != null) return dp[cur][amt];
        
        int currentAmt = coins[cur];
        int consider = 10001;
        
        if(currentAmt <= amt)
            consider =  1+change(amt-currentAmt,coins,cur,n,dp);
        int dontConsider = change(amt,coins,cur+1,n,dp);
        
        dp[cur][amt] = Math.min(consider,dontConsider); 
        return dp[cur][amt];
        
        
    }
}