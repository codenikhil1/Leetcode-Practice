class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length ==0 || nums == null)
            return ans;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n ; i++ ){
            int left = i+1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if( sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp); 
                    int leftvalue = nums[left];
                    //bypass dublicate
                    while(left < n && leftvalue == nums[left])
                        left++;
                    int rightvalue = nums[right];
                    while(right > left && rightvalue == nums[right])
                        right--;
                }else if (sum < 0){
                    left++;
                }else
                    right--;
            }
            //bypass dublicate
            while(i+1 < n && nums[i] == nums[i+1])
                i++;
        }
        return ans;
            
    }
}