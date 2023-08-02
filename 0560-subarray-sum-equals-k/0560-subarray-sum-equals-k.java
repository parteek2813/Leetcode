// class Solution {
    
    
//     public static int countSubsets(int[] nums, int i , int currSum, int k){
        
//            // base cond 1
//         if(i== nums.length){
//            if(currSum == k){
//                return 1;
//            }
//             return 0;
//         }
        
//        // base cond 2
//         if(currSum > k){
//             return 0;
//         }
        
//         // rec case
//         int x = countSubsets(nums, i+1, currSum + nums[i], k);
//         int y = countSubsets(nums, i+1, currSum, k);
        
//         return x+y;
//     }
    
//     public static int getSubsets(int[] nums, int k){
//         int res = countSubsets(nums, 0, 0, k);
//         return res;
//     }
    
    
//     public int subarraySum(int[] nums, int k) {
//         int count = getSubsets(nums, k);
//         return count;
//     }
// }


import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cumulativeSum = 0;
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();

        // Initializing the HashMap with cumulative sum 0 and frequency 1.
        sumFrequency.put(0, 1);

        for (int num : nums) {
            cumulativeSum += num;

            // Check if there is a subarray with sum equal to k.
            if (sumFrequency.containsKey(cumulativeSum - k)) {
                count += sumFrequency.get(cumulativeSum - k);
            }

            // Increment the frequency of cumulativeSum in the HashMap.
            sumFrequency.put(cumulativeSum, sumFrequency.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
