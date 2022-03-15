class Solution {
    public int climbStairs(int n) {
        int arr[] = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++ ){
            arr[i] = -1;
        }
        return climb(n,0,arr);
    }
    
    public int climb(int n,int cur,int[] arr){
        
        if(cur < arr.length && arr[cur] != -1) return arr[cur];
        
        if(cur > n) return 0;
        if(cur == n) return 1;
        
        int ans =  climb(n,cur+1,arr)+climb(n,cur+2,arr);
        
        arr[cur]  = ans;
        
        return ans;
    }
}