// class Solution {
// public:
//     int K;
//     int n;
    
//     unordered_map<string, int> mp;
    
    
//     int solve(int prev, int i, vector<int>& nums){
        
//         if(i >= n)
//             return 0;
        
        
//         string key = to_string(prev) + "_" + to_string(i);
        
//         if(mp.find(key) != mp.end()){
//             return mp[key];
//         }
        
//         int result = 0;
        
//         if(prev == -1 || i-prev <= K){
            
//             int take = nums[i] + solve(i, i+1, nums); 
            
//             int not_take = solve(prev, i+1, nums);
            
//             result = max(take, not_take);
//         }
        
//         return  mp[key]= result;
//     }
    
//     int constrainedSubsetSum(vector<int>& nums, int k) {
        
//         n = nums.size();
//         K = k;
        
//         int val = solve(-1, 0, nums);
        
//         if(val ==0){
//              val = *max_element(nums.begin(), nums.end());
//         }
        
//         return val;
        
    
//     }
// };



class Solution {
public:
        typedef pair<int,int> P;

        int constrainedSubsetSum(vector<int>& nums, int k) {
            
            int n = nums.size();
            
            vector<int> t(n);
            
            
            for(int i =0; i<n; i++){
                t[i] = nums[i];
            }
            
            
            priority_queue<P> pq;
            pq.push({t[0], 0});
            
            int result = t[0];
            
            for(int i=1; i<n; i++){
                
                
//                 METHOD 1 
//                 for(int j=i-1; j >= 0 && i-j <= k; j--){
//                     t[i] = max(t[i], nums[i] + t[j]);
                    
//                     result = max(result, t[i]);
//                 }
                
                
//                 METHOD 2
                
//                 NOTE: The while loop will be amortised O(1)
//                 AN element is pushed/popper only once.
//                 
//                 Also play, the max size of priority queue will go
//                 till n when we never pop any element so it will be 
//                 O(logN)
                
                while(!pq.empty() && i-pq.top().second > k){
                    
                    pq.pop();
                }
                
                t[i] = max(t[i], nums[i] + pq.top().first);
                pq.push({t[i], i});
                
                result = max(result, t[i]);
                
            }
            
            return result;
        }
        
        
    };
