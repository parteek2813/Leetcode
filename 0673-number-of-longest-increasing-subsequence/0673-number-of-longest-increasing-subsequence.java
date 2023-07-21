class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxLen = 1;
        //Step 1
        int [] dp = new int[nums.length];
        int [] count = new int[nums.length];

        //Step 2
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        //Step 3
        for(int k = 1; k < nums.length; k++)
        {
            for(int j = 0; j < k; j++)
            {
                if(nums[k] > nums[j])
                {
                    //Step 4
                    if(dp[k] < dp[j] + 1)
                    {
                        dp[k] = dp[j] + 1;
                        count[k] = count[j];
                    }

                    //Step 5
                    else if(dp[k] == dp[j] + 1)
                    {
                        count[k] += count[j];
                    }
                }
            }
            //Step 6
            maxLen = Math.max(maxLen,dp[k]);
        }

        //Step 7
        int result = 0;
        for(int k = 0; k < nums.length;k++)
        {
            if(maxLen == dp[k]) result += count[k];
        }
        return result;
    }
}
