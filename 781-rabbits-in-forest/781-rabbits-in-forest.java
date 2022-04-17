class Solution {
    public int numRabbits(int[] answers) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        Set<Integer> set = new HashSet<>();
        double ans = 0;
        
        for(int num : answers){
            map.put(num,map.getOrDefault(num,0)+1);     
        }
        
        for(int key : map.keySet()){
            double groupSize = key + 1;
            double numberOfGroups =Math.ceil(map.get(key)/groupSize);
            
            ans += numberOfGroups*groupSize;
            
        }
        return (int)ans;
       
    }
}

  