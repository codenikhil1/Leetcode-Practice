class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[] = new Boolean[nums.length+1];
        return isPossible(nums,0,dp);
    }
    
    private boolean isPossible(int[] nums,int currentIndex,Boolean dp[]){
        if(currentIndex >= nums.length - 1 ) return true;
        
        if(dp[currentIndex] != null) return dp[currentIndex];
        
        int maxJumps = nums[currentIndex];
        
        for(int i = 1 ; i <= maxJumps ; i++ ){
            if(isPossible(nums,currentIndex+i,dp)){
                dp[currentIndex] = true;
                return true;
            }
        }
        
        dp[currentIndex] = false;
        return false;
        
        
        
    }
}