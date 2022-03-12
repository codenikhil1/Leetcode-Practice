class Solution {
    public void nextPermutation(int[] nums) {
     int n = nums.length;
     int i = n-2;
     int index = -1;
     while(i>=0){
         if(nums[i]<nums[i+1])
             break;
         i--;
     }
     if(i>=0){
         int j = n-1;
         while(j > i){
             if(nums[j] > nums[i]){
                 swap(nums,i,j);
                 break;
             } 
             j--;
         }
     }   
     reverse(nums,i+1);        
        
    }
    
     private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}