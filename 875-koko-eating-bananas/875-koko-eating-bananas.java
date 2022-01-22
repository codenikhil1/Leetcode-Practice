class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int max = Integer.MIN_VALUE;
        for(int temp : piles){
            max = Math.max(temp,max);
        }
        int left = 1;
        int right = max;
        
        return binarySearch(left,right,piles,h);
        
    }
    
    public int binarySearch(int left,int right,int[] piles,int h){
        int ans = Integer.MAX_VALUE;
        int len = piles.length;
        int i = 0;
        int count = 0;
        while(left < right){
            int mid = (left+right)/2;
            count = 0;
          
            for(int pile : piles){
                count += Math.ceil((double)pile/mid);
            }
           
            
            
            if(count <= h){
                right = mid;
            }else
                left = mid + 1;
        }
                
        
        return right;
    }
}