class Solution {
    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length+1][2][2]; 
        return profit(prices,0,0,1,dp);
    }
    
    private int profit(int[] prices,int current,int canIBuy,int                                                             noOfTransaction,Integer[][][] dp){
        if(current >= prices.length || noOfTransaction == 0 ) return 0;
        
        int buyStock = 0;
        int sellStock = 0;
        
        if(dp[current][canIBuy][noOfTransaction] != null)
            return dp[current][canIBuy][noOfTransaction];
        //String key = current + "-" + canIBuy + "-" + noOfTransaction;
        
        //if(map.containsKey(key)) return map.get(key);
        
        int Idle = profit(prices,current+1,canIBuy,noOfTransaction,dp);
        
        if(canIBuy == 0)
            buyStock = -prices[current]+profit(prices,current+1,1,1,dp);
        else
            sellStock = prices[current]+profit(prices,current+1,0,0,dp);
        
        dp[current][canIBuy][noOfTransaction] = Math.max(Idle,Math.max(buyStock,sellStock));
        
        //map.put(key,Math.max(Idle,Math.max(buyStock,sellStock)));
        
        return dp[current][canIBuy][noOfTransaction];
        
            
        
        
    }
}