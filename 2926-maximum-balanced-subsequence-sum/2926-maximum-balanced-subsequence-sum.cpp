class Solution {
public:
    long long maxBalancedSubsequenceSum(vector<int>& nums) {
//         // Using bottom Up solution
        
//         int n = nums.size();
        
//         int maxEl = *max_element(begin(nums),end(nums));
        
//         if(maxEl <= 0){
//             return maxEl;
//         };
        
        
        
//         vector<long long> t(n);
//         // here t[i] equals the = maximum BalancedSubsequenceSum till index i
        
//         // seed the inital value same as the given array
//         for(int i =0; i<n; i++){
//             t[i] = nums[i];
//         };
        
//         long long maxSum = INT_MIN;
        
        
//         for(int i =0; i<n; i++){
//             for(int j=0; j<i; j++){
                
                
//                 if(nums[i] - i >= nums[j] - j){
//                     t[i] = max<long long>(t[i], t[j] + nums[i]);
                    
//                     maxSum = max(maxSum, t[i]);
//                 }
//             }
//         }
        
//         return maxSum;
        
        
//         APPROACH 2 - Most Optimized Approach - Maintaining the map and then deleting some 
        
        int n = nums.size();
        
        map<int, long long> mp; // nums[i] - i , sum
        
        long long result = INT_MIN;
        
        for(int i =0; i<n; i++){ // O(N)
            
            // log(n) in worst case
            auto it = mp.upper_bound(nums[i] - i); // it->first (nums[j] - j ) , it-> second: sum
            
            
            long long sum = nums[i];
            
            
             if(it != mp.begin()){
                it--;
                sum += it->second;
             };
            
            mp[nums[i] - i] = max(mp[nums[i] - i], sum);
            
            
            
            it = mp.upper_bound(nums[i] - i);
            
            // delete kardo chote ya equal walo ko jab tak condition satisfy ho rahi hein!
            while(it != mp.end() && it->second <= sum){
                mp.erase(it++); // no impact of this loop in the condition
            }
            
            result = max(result, sum);
            
            
            
            
        }
        return result;
        
    }
};