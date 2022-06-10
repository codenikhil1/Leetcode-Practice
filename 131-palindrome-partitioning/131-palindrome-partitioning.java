class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        int n = s.length();
        part(s, 0, n, new ArrayList<String>());
        return res;
    }
    
    private void part(String s, int start, int end, List<String> cur) {
        if (start >= end) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        
        for(int i = start; i < end; i++) {
            String sub = s.substring(start, i + 1);
            if(isPal(sub)) {
                cur.add(sub);
                part(s, i + 1, end, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPal(String s) {
        int n = s.length();
        
        for(int i=0, j=n-1; i<n/2; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}