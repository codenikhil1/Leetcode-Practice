class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
        return LCS(s1,s2,0,0,s1.length(),s2.length(),dp);
    }
    
    private int LCS(String s1, String s2,int i,int j,int m,int n,Integer[][] dp){
        if(i >= m || j >=n) return 0;
        
        int ans = -1;
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            ans= 1+ LCS(s1,s2,i+1,j+1,m,n,dp);
        }else{
            int temp1 = LCS(s1,s2,i+1,j,m,n,dp);
            int temp2= LCS(s1,s2,i,j+1,m,n,dp);
            ans = Math.max(temp1,temp2);
        }
        
        dp[i][j] = ans;
        
        return ans;
    }
}