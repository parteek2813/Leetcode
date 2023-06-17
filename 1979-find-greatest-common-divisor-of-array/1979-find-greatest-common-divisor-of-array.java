class Solution {
    public int findGCD(int[] nums) {
        
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[nums.length-1];
        
        while(a != 0){
            int temp= a;
             a = b%a;
             b = temp;
        }

        return b;

    }
}