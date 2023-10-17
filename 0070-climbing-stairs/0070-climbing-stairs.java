
import java.util.Arrays;
class Solution {
//     public int climbStairs(int n) {
//         if(n==1) return 1;
        
//         if(n==2) return 2;

//         int[] a =  new int[n];
//         a[0]=1;
//         a[1]=2;

//         for(int i=2;i<n;i++){
//             a[i]=a[i-1]+a[i-2];
//         }
//         return  a [n-1];
//     }
    
    public static int climbS(int n , int[] dp){
        if(n == 0 ) return 1;
        if(n==1) return 1;
        
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int left = climbS(n-1, dp);
        int right = climbS(n-2, dp);
        
        return  dp[n] = left + right;
    } 
    
     public static int climbSBottomUp(int n ){
         
         
         int[] dp = new int[n+1];
         dp[0] = 1;
         dp[1] = 1;
         
         for(int i =2; i<=n; i++){
             
             dp[i] = dp[i-1] + dp[i-2];
             
         }
         
         return dp[n];
     }
    
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int res = climbS(n, dp);
        
        int result = climbSBottomUp(n);
        
        return result;
    }
}