class Solution {
    int n;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[2501][2501];
        for(int[] a : dp)
        {
            Arrays.fill(a,-1);
        }

        return lis(nums,0,-1);
    }

    public int lis(int[] nums , int curr , int prev)
    {
        if(curr >= n)
        {
            return 0;
        }

        if( prev != -1 && dp[curr][prev] != -1)
        {
            return dp[curr][prev];
        }
        int taken = 0;

        if(prev == -1 || nums[curr] > nums[prev])
        {
            taken = 1 + lis(nums,curr + 1 , curr);
        }

        int skip = lis(nums,curr + 1,prev);

        if(prev != -1)
        {
          dp[curr][prev] = Math.max(taken , skip);
        }
        return Math.max(taken , skip);
    }
}
