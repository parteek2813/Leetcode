class Solution {
    public int longestSubarray(int[] nums) {
        // Time = O(N);
        // space = O(1) no extra data structures required
        
        int n = nums.length;
        int i =0;
        int j =0;
        int ans =0;
        int zeroCnt = 0;
        
        while(j<n){
            if(nums[j] == 0){
                zeroCnt++;
            }
            
            // check if zerocnt become more than 1 if yes shrink the sliding window to fit 
            // the condition
            if(zeroCnt > 1){
                while(zeroCnt > 1){
                    if(nums[i] == 0){
                        zeroCnt--;
                    }
                    i++;
                }
            }else{
                ans = Math.max(ans, j-i);
                
            }
            j++; 
        }
        return ans;
        
        
    }
}