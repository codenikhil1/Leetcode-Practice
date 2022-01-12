class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        int max = Integer.MIN_VALUE;
        for(int num : set){
            
            //if set not contains elem - 1
            if(!set.contains(num-1)){
                int curmax = 1;
                int next = num+1;
                
                //check until next elem present in set
                while(set.contains(next)){
                    curmax+=1;
                    next+=1;
                }
             //compare with previous max   
            max = Math.max(max,curmax);
            }
        }
        return max;
    }
}