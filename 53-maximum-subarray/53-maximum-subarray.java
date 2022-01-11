class Solution {
    public int maxSubArray(int[] nums) {
        int mtn = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length ; i++ ){
            mtn+=nums[i];
            
            if( nums[i] > mtn) mtn = nums[i];
            
            if(mtn > max) max = mtn;
        }
        
        return max;
    }
}