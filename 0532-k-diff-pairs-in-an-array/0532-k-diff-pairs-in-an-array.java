

class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        if (k < 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        
       int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (i == j || nums[j] - nums[i] < k) {
                // Move j to find a pair with a difference of k
                j++;
            } else if (nums[j] - nums[i] > k) {
                // Move i to decrease the difference
                i++;
            } else {
                // Found a valid pair
                count++;
                i++;
                j++;
                // Avoid counting duplicate pairs with the same first element
                while (j < n && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
        }
        
        
//         for(int i =0; i<n; i++){
//             for(int j =i+1; j<n; j++){
//                 if(Math.abs(nums[i] - nums[i+1]) == k){
//                     count++;
                    
//                 }
//             }
//         }
        
        
        return count;
               
    }
}