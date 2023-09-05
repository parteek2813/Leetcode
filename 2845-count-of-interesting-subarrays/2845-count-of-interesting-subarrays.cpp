class Solution {
public:
    long long countInterestingSubarrays(vector<int>& nums, int modulo, int k) {
        unordered_map<long long, long long> mp;
        long long ans =0, prefix=0, n=nums.size();
        
        mp[0]++;
        
        for(int i =0; i<n; i++){
            if(nums[i]%modulo ==k){
                prefix++;
            }
            
            prefix%=modulo;
            
            ans+=mp[(prefix-k+modulo)%modulo];
            
            mp[prefix]++;
            
        }
        return ans;
    }
};