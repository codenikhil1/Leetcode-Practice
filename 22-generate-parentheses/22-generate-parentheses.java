class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,0,0,ans,"");
        return ans;
    }
    
    private void generate(int n,int openCount,int closeCount,List<String> ans,String currentAns){
        if(openCount == closeCount && openCount == n){
            ans.add(currentAns);
            return;
        }
        
        if(openCount < n)
            generate(n,openCount+1,closeCount,ans,currentAns+"(");
        
        if(openCount > closeCount)
            generate(n,openCount,closeCount+1,ans,currentAns+")");
        
        return;
    }
}