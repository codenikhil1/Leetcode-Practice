class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max_prof = 0;
        int low = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < len-1 ; i++ ){
            low = Math.min(low,prices[i]);
            int profit = prices[i+1] - low;
            
            max_prof = Math.max(profit,max_prof);
        }
        
        return max_prof;
    }
}