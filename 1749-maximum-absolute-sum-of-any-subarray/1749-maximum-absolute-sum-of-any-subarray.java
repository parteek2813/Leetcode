class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max1, max2;
        max1 = maxSum(nums);
        
        for(int i = 0; i < nums.length; i++)
          nums[i] *= -1;
        
        max2 = maxSum(nums);

        return Math.max(max1, max2);
    }

    
    private int maxSum(int[] nums){
        int n = nums.length, cur = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(cur < 0)
                cur = nums[i];
            else 
                cur += nums[i];

            result = Math.max(result, cur);
        }

        return result;
    }
}