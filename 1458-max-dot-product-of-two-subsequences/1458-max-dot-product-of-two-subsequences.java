class Solution {
    
    static int m , n;
    static int dp[][] = new int[501][501];
    
    public static int solve(int[] nums1, int[] nums2, int i, int j){
        
        // base case
        if(i== m || j == n){
            return -100000000;
        }
        
        if(dp[i][j] != -100000000)
            return dp[i][j];
        
        // rec case
        
        int product_both = nums1[i]* nums2[j];
        
        int take_i_j = nums1[i]* nums2[j] + solve(nums1, nums2, i+1, j+1);
        
        int take_i = solve(nums1, nums2, i, j+1);
        
        int take_j = solve(nums1 , nums2, i+1, j);
        
        int temp_max = Math.max(product_both, take_i_j);
        int again_max =  Math.max(temp_max, take_i);
        
        return dp[i][j] = Math.max(again_max,take_j);
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        m = nums1.length;
        n = nums2.length;
        
        // filling out the dp array
        for(int i =0; i<501; i++){
            for(int j =0; j<501; j++){
                dp[i][j] = -100000000;
            }
        }
        
        int result = solve(nums1,nums2, 0,0);
        return result;
        
    }
}