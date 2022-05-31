class Solution {
    private static String[] KEY_MAPPING = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
            return ans;
        generate(digits,ans,0,"");
        return ans;
    }
    
    private void generate(String digits,List<String> ans,int currentIndex,String currentAns){
        if(digits.length() == currentIndex){
            ans.add(currentAns);
            return;
        }
        
        char currentChar = digits.charAt(currentIndex);
        String letters = KEY_MAPPING[currentChar - '0'];
        for(int i = 0 ; i < letters.length() ; i++ ){
            generate(digits,ans,currentIndex+1,currentAns+letters.charAt(i));
        }
        
        return;
    }
    
    
}