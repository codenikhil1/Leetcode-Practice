class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       
        int atMostK = atMost(nums,k);
        int atMostKminusOne = atMost(nums,k-1);
        
        return atMostK - atMostKminusOne;
    
    }
    
    private int atMost(int[] nums,int k){
         HashMap<Integer,Integer> map = new HashMap<>();
         int distinct = 0;
         int ans = 0;
         int release = 0;
        for(int i = 0 ; i < nums.length ; i++ ){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
                distinct++;
            }
            
            while(release <= i && distinct > k){
                
                map.put(nums[release],map.get(nums[release])-1);
                
                if(map.get(nums[release]) == 0){
                    map.remove(nums[release]);
                    distinct--;
                }
                
                release++;
            }
            
            ans+= i - release + 1;
        }
        return ans;
         
    }
}