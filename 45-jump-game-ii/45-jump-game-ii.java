class Solution {
    public int jump(int[] nums) {
        Integer dp[] = new Integer[nums.length+1];
        return minJump(nums,0,dp);
    }
    
    private int minJump(int[] nums,int currentIndex,Integer[] dp){
        if(currentIndex >= nums.length-1) return 0;
        
        if(dp[currentIndex] != null) return dp[currentIndex];
        int ans = 10001;
        
        int maxJumps = nums[currentIndex];
        
        for(int i = 1 ; i <= maxJumps ; i++ ){
            int min = 1+minJump(nums,currentIndex+i,dp);
            ans = Math.min(min,ans);
        }
        
        dp[currentIndex] = ans;
        
        return ans;
        
    }
}