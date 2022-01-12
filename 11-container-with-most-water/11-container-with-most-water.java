class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;
        while(left<right){
            if(height[left] < height[right]){
                int tempans =  height[left] * (right - left);
                ans = Math.max(ans,tempans);
                left++;
            }else{
                int tempans = height[right]  * (right - left);
                ans = Math.max(ans,tempans);
                right--;
            }
        }
        return ans;
    }
}