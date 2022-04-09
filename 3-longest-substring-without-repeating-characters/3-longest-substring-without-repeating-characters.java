class Solution {
    public int lengthOfLongestSubstring(String s) {
            
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int release = 0;
        for(int i = 0 ; i < s.length() ; i++ ){
            char currentChar = s.charAt(i);
            
            if(map.containsKey(currentChar) && map.get(currentChar) >= release){
                int index = map.get(currentChar);
                release = index+1;
            }
            map.put(currentChar,i);
            int tempAns = (i - release) + 1;    
            ans = Math.max(ans,tempAns);
        }
        
        return ans;
        
        
    }
}