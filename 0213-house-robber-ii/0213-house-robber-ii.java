// class Solution {
    
    
//      public static int maxNonSum(List<Integer> nums){
//         int n = nums.size();
//         int prev2 = nums.get(0);
//         int prev = Math.max(nums.get(0), nums.get(1)); // Handle case when n >= 2
        
//         for(int i = 2; i < n; i++){
//             int take = nums.get(i) + prev2;
//             int notTake = prev;
            
//             int curri = Math.max(take, notTake);
//             prev2 = prev;
//             prev = curri;
//         }
        
//         return prev;
        
//     }
    
    
//     public int rob(int[] nums) {
//         int n = nums.length;
        
        
//         if(n==1) return nums[0];
        
//         List<Integer> temp1 = new ArrayList<>();
//         List<Integer> temp2 = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             if (i != 0) temp1.add(nums[i]);
//             if (i != n - 1) temp2.add(nums[i]);
            
//         }

//         return Math.max(maxNonSum(temp1), maxNonSum(temp2));
//     }
// }


class Solution {
    public int rob(int[] nums) {
      if(nums.length<2) return nums[0];  
      int []skipfirst=new int[nums.length-1];
      int []skiplast=new int[nums.length-1];
      for(int i=0;i<nums.length-1;i++){
          skiplast[i]=nums[i];
          skipfirst[i]=nums[i+1];
      }
      int dp1[]=new int[nums.length];
      int dp2[]=new int[nums.length];
      Arrays.fill(dp1,-1);
      Arrays.fill(dp2,-1);
      return Math.max(solve(0,skiplast,dp1),solve(0,skipfirst,dp2));  
    }
    public static int solve(int i,int []nums,int dp[]){
        if(i>=nums.length) return 0;
        int left=0;
        int right=0;
        if(dp[i]!=-1)return dp[i];
        if(i<nums.length) left=nums[i]+solve(i+2,nums,dp);
        if(i+1<nums.length) right=nums[i+1]+solve(i+3,nums,dp);
        return dp[i]=Math.max(left,right);
    }
}


