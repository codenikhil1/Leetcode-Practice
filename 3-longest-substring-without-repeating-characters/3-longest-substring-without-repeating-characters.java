class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int windowSize = 0;
        int winLen = 0;
        
        while (j < len ){
            char temp = s.charAt(j);
            if(map.containsKey(temp) && i<=map.get(temp)){
                i = map.get(temp)+1;
                winLen = j - i;
            }
            
            map.put(temp,j);
            winLen++;
            j++;
            
            if(winLen > windowSize){
                windowSize = winLen;
            }
        }
        return windowSize;
        
    }
}