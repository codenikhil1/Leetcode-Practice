class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
       return numOfRolls(n,k,target,dp);
    }
    
    private int numOfRolls(int noOfDices,int faces,int target,Integer[][] dp){
        if(noOfDices == 0 && target == 0) return 1;
        
        if(noOfDices == 0 || target <= 0) return 0;
        int ans = 0;
        
        int MOD = 1000000007;
        
        
        
        if(dp[noOfDices][target] != null) return dp[noOfDices][target]; 
        
        for(int i = 1 ; i <= faces ; i++ ){
           int temp = numOfRolls(noOfDices-1,faces,target-i,dp);
                         //(a+b) % c = (a%c + b%c) %c;
                        // a-> temp , b-> ans , c-> MOD
           temp = temp % MOD;
           ans = ans % MOD;
           ans = (ans+temp) % MOD; 
        }
        
        dp[noOfDices][target] = ans; 
        
        return dp[noOfDices][target];
        
    }
}