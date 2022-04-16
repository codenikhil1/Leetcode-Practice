// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        long ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        map.put("0#0",1);
        for(int i = 0 ; i < str.length() ; i++ ){
            char currentNum = str.charAt(i);
            if(currentNum == '0')
                z0++;
            else if (currentNum == '1')
                z1++;
            else
                z2++;
            
            String key = String.valueOf(z1-z0) + "#" + String.valueOf(z2-z1);
            
            if(map.containsKey(key)){
                ans+= map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        
        return ans;
    }
} 