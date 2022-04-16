class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans = 0;
        int sum  = 0;
        
        map.put(0,1);
        
        for(int i = 0 ; i < nums.length ; i++ ){
            sum += nums[i];
            
            int mod = (((sum%k)+k)%k);
            
            if(map.containsKey(mod)){
                ans+=map.get(mod);
                map.put(mod,map.get(mod)+1);
            }else{
                map.put(mod,1);
            }
            
        }
        
        return ans;
    }
}