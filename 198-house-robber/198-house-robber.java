class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        for(int i = 0 ; i <= n ; i++ )
            dp[i]=-1;
        return robHouse(nums,0,dp);
    }
    public int robHouse(int[] nums, int houseNo,int dp[]){
        if(houseNo >= nums.length) return 0;
        
        if(dp[houseNo] !=-1 ) return dp[houseNo];
        
        int robThisHouse = nums[houseNo] + robHouse(nums,houseNo+2,dp);
        int dontRobHouse = robHouse(nums,houseNo+1,dp);
        
        int MaxAmount = Math.max(robThisHouse,dontRobHouse);
        
        dp[houseNo] = MaxAmount; 
        return MaxAmount;
        
    }
}