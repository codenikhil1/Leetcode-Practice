class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        
        return targetSum(nums,target,0,n,new HashMap<String,Integer>());
    }
    
    private int targetSum(int[] nums , int target , int curElem ,int n,HashMap<String,Integer> map  ){
        if(curElem == n )
            if(target == 0 ) return 1;
        else
            return 0;
        
        String key = Integer.toString(curElem) + "-" +Integer.toString(target);
        
        if(map.containsKey(key)) return map.get(key);
                    
        int addCurElem = targetSum(nums,target + nums[curElem],curElem+1,n,map);
        int substractElem = targetSum(nums,target - nums[curElem],curElem+1,n,map);
        
        map.put(key,addCurElem + substractElem);
        
        return map.get(key);
        
    }
}