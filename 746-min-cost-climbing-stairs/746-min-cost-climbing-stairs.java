class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int dp[] = new int[cost.length + 1];
        for(int i = 0 ; i < dp.length;i++) dp[i] = -1;
        
        int startFromZero = costToClimb(cost,0,dp);
        int startFromFirst = costToClimb(cost,1,dp);
        
        return Math.min(startFromZero,startFromFirst);
    }
    
    public int costToClimb(int[] cost, int stair,int dp[]){
        if(cost.length == stair) return 0;
        if(stair > cost.length) return Integer.MAX_VALUE;
        if(dp[stair] != -1) return dp[stair];
        
        int jumpOne = costToClimb(cost,stair+1,dp);
        int jumpTwo = costToClimb(cost,stair+2,dp);
        
        if(jumpOne == Integer.MAX_VALUE ){
            dp[stair] = jumpTwo+cost[stair];
            return jumpTwo+cost[stair];
        } 
        if(jumpTwo == Integer.MAX_VALUE){
            dp[stair] = jumpOne+cost[stair];
            return jumpOne+cost[stair];
        }
        
        int ans = Math.min(jumpTwo+cost[stair],jumpOne+cost[stair]);
        dp[stair] = ans;
        return ans; 
    }
}