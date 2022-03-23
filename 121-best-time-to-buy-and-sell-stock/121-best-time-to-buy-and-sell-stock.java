class Solution {
    public int maxProfit(int[] prices) {
       // Integer[][][] dp = new Integer[current+1][2][2]; 
        return profit(prices,0,0,1,new HashMap<String,Integer>());
    }
    
    private int profit(int[] prices,int current,int canIBuy,int                                                             noOfTransaction,HashMap<String,Integer> map){
        if(current >= prices.length || noOfTransaction == 0 ) return 0;
        
        int buyStock = 0;
        int sellStock = 0;
        
        String key = current + "-" + canIBuy + "-" + noOfTransaction;
        
        if(map.containsKey(key)) return map.get(key);
        
        int Idle = profit(prices,current+1,canIBuy,noOfTransaction,map);
        
        if(canIBuy == 0)
            buyStock = -prices[current]+profit(prices,current+1,1,1,map);
        else
            sellStock = prices[current]+profit(prices,current+1,0,0,map);
        
        map.put(key,Math.max(Idle,Math.max(buyStock,sellStock)));
        return map.get(key);
        
            
        
        
    }
}