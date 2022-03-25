// { Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            
            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        Long[][] dp = new Long[(int)n+5][1001];
        int[] scores = new int[]{3,5,10};
        return totalWays(0,n,scores,dp);
    }
    
    private long totalWays(int current,int totalScore,int[] scores,Long[][] dp){
        if(totalScore == 0) return 1;
        
        if(current >= scores.length ) return 0;
      
        if(dp[current][totalScore] != null) return dp[current][totalScore];

        long consider = 0;
        
        if(scores[current] <= totalScore)
            consider = totalWays(current,totalScore-scores[current],scores,dp);
        long notConsider = totalWays(current+1,totalScore,scores,dp);
        
        dp[current][totalScore] = consider+notConsider;
        
        return dp[current][totalScore];
        
        
    }
}