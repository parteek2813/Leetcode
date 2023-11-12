class Solution {
    public int[] singleNumber(int[] nums) {
        int xors = 0;
        int n = nums.length;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n; i++)
            xors ^= nums[i];
        xors = xors & ~(xors - 1);            
        for (int i = 0; i < n; i++){
          if ((xors & nums[i]) != 0) num1 ^= nums[i];
          else num2 ^= nums[i];
        }
            
        return new int [] {num1, num2};

        
    }
}