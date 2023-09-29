//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public static long findthePairsAgain(int n){
        // base case
        if (n <= 2) {
            return n;
        }
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){ 
            dp[i] = (dp[i-1] + (i-1)*dp[i-2]) % 1000000007;
        }
        
        return dp[n]; 
    }
    
    // public static long findThePairs(int n){
    //     // base case
    //     if(n<3){
    //         return (long)n;
    //     }
        
    //     long first =1;
    //     long second = 2;
    //     int mod = 1000000007;
        
    //     for(int i=3; i<=n; i++){
    //         long ways = second + (((i-1)*first) % mod);
    //         first = second;
    //         second = ways % mod;
    //     }
        
    //     return second;
        
    // }
    
    public long countFriendsPairings(int n) 
    { 
       long res = findthePairsAgain(n);
       return res;
    }
}    
 