class Solution {
    public int minCut(String s) {
        Integer dp[] = new Integer[s.length()+1];
        return minCutPal(s,0,s.length()-1,dp);
    }
    private int minCutPal(String s,int start,int end,Integer[] dp){
        if(isPal(s,start,end)  || start == end || start > end) return 0;
        
        if(dp[start] != null) return dp[start];
        
        int ans = 10000001;
        
        for(int i = start;i<end;i++){
            
            if(isPal(s,start,i)){
               int rightHalf=1+minCutPal(s,i+1,end,dp);
               ans = Math.min(ans,rightHalf); 
            }
                
        
        }
        dp[start] = ans;
        return ans;
    }
    
    private boolean isPal(String s,int start,int end){
    
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}