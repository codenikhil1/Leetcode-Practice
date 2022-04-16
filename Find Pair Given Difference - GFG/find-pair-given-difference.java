// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       
       for(int i = 0 ; i < arr.length ; i++ ){
           
           int complement1 = n + arr[i];
           int complement2 = arr[i] - n;
           
           if(map.containsKey(complement1) || map.containsKey(complement2)){
               return true;
           }else{
               map.put(arr[i],1);
           }
       }
       
       return false;
    }
}