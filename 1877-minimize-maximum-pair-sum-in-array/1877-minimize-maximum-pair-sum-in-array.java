class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int maxVal = Integer.MIN_VALUE;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            maxVal = Math.max(maxVal, nums[i]+nums[j]);
            i++;
            j--;
        }
        
        return maxVal;
    }
}