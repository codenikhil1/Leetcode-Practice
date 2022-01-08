class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int cnt = 0;
        int start = 0; // left
        int start_index = -1;
        int min_so_far = Integer.MAX_VALUE;
        int window_size = 0;
        //store frequency of char of small string
        for(int i = 0 ;i < t.length();i++){
                map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
        }
        
        for(int i = 0 ; i < s.length() ;i++ ){
            char ch = s.charAt(i);
                map2.put(ch,map2.getOrDefault(ch,0)+1);         
            //if char is present is small string
            //and its freq in map2 is less than in map1 mean we need that char
            // or else we dont need that char as we already have char freq we wanted
            if(map1.getOrDefault(ch,0) != 0 && map2.getOrDefault(ch,0) <= map1.getOrDefault(ch,0))
                cnt++;
            
            //we got all char with required frequency or greater freq
            if(cnt == t.length()){
                //will contract window from length and try to reduce window size
                while(map1.getOrDefault(s.charAt(start),0) == 0 || map1.getOrDefault(s.charAt(start),0) < 
                      map2.getOrDefault(s.charAt(start),0)){
                    map2.put(s.charAt(start),map2.getOrDefault(s.charAt(start),0)-1);
                    start++;
                }
                
                window_size = i - start + 1;
                if(window_size < min_so_far){
                    min_so_far = window_size;
                    start_index = start;
                }
                
            }
        
            
        }
        
        if(start_index == -1) return "";
        return s.substring(start_index,start_index+min_so_far);
    }
}