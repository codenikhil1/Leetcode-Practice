class Solution {
    public int[] sortArray(int[] nums) {
        return merge_sort(nums,0,nums.length-1);
    }
    
    public int[] merge_sort(int[] nums,int first,int last){
        if(first == last) return new int[]{nums[first]};
        
        int mid = (first+last)/2;
        
        int[] left = merge_sort(nums,first,mid);
        int[] right = merge_sort(nums,mid+1,last);
        
        int ans[] = new int[left.length+right.length];
        int i = 0,j=0,k=0;
        
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                ans[k] = left[i];
                i++;
                k++;
            }else{
                ans[k] = right[j];
                j++;
                k++;                
            }
        }
        
        if(i<left.length){
            while( i < left.length){
                ans[k] = left[i];
                i++;k++;
            }
        }
        if(j<right.length){
            while( j < right.length){
                ans[k] = right[j];
                j++;k++;
            }
        }
        return ans;
    }
}