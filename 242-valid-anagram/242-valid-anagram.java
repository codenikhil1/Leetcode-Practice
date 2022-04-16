class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        
        
        for(int i = 0 ; i < s.length() ; i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0 ; i < t.length() ; i++){
            map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)-1);
            
        }
        
        for(Integer n : map1.values()){
            if(n != 0) return false;
        }
        
        return true;
        
    }
}