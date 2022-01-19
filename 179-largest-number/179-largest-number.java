class Solution {
    private class LargerNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a,String b){
            String o1 = a+b;
            String o2 = b+a;
            
            return o2.compareTo(o1);
        }
    }
    public String largestNumber(int[] nums) {
            String str[] = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++ ){
            str[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(str,new LargerNumberComparator());
        
        
        if(str[0].equals("0"))
            return "0";
        
        String ans = "";
        for(String temp : str)
            ans+=temp;
        
        return ans;     

    }
}