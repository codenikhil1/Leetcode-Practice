class Solution {
    public int majorityElement(int[] nums) {
        
        int cand = 0;
        int count = 0;
        
        for(int num : nums){
            if(count == 0)
                cand = num;
            if(num == cand)
                count++;
            else
                count--;
        }
        
        return cand;
    }
}