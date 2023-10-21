class Solution {
    
    
    public static int maxNonSum(List<Integer> nums){
        int n = nums.size();
        int prev2 = nums.get(0);
        int prev = Math.max(nums.get(0), nums.get(1)); // Handle case when n >= 2
        
        for(int i = 2; i < n; i++){
            int take = nums.get(i) + prev2;
            int notTake = prev;
            
            int curri = Math.max(take, notTake);
            prev2 = prev;
            prev = curri;
        }
        
        return prev;
        
    }
    
    
    public int rob(int[] nums) {
       
        int n = nums.length;
        
        
        if(n==1) return nums[0];
        
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // if (i != 0) temp1.add(nums[i]);
            // if (i != n - 1) temp2.add(nums[i]);
            
            temp1.add(nums[i]);
        }

        return maxNonSum(temp1);
        
        
    }
}