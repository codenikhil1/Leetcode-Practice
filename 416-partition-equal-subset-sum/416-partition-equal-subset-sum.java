class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums)
            sum+=num;
        if(sum%2 != 0) return false;
        
        Boolean dp[][] = new Boolean[n][sum/2+1];
        
        return canPart(nums,sum/2,0,n,dp);
    }
    
    private boolean canPart(int[] nums, int target ,
                            int currentElem, int n,Boolean dp[][]){
        if(currentElem >= n) return false;
        
        if(target == 0) return true;
        
        if(dp[currentElem][target] != null ) return dp[currentElem][target]; 
    
        
        int nextTarget = target - nums[currentElem];
        
        boolean consider = false;
        
        if(nextTarget >= 0)
           consider = canPart(nums,nextTarget,currentElem+1,n,dp);
        
        boolean dontConsider = canPart(nums,target,currentElem+1,n,dp);
        
        dp[currentElem][target] = consider || dontConsider;
        
        return dp[currentElem][target];
    }
}