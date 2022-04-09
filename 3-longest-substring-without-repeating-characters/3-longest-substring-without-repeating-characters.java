class Solution {
    public int lengthOfLongestSubstring(String s) {
            
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int release = 0;
        for(int i = 0 ; i < s.length() ; i++ ){
            char currentChar = s.charAt(i);
            
            while(map.containsKey(currentChar)){
                char discartChar = s.charAt(release);
                map.remove(discartChar);
                release++;
            }
            map.put(currentChar,i);
            int tempAns = (i - release) + 1;
            ans = Math.max(ans,tempAns);
        }
        
        return ans;
        
        
    }
}