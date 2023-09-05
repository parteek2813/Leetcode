class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Long, Long> mp = new HashMap();
        
        long ans =0, prefix=0;
        int n =  nums.size();
        
        mp.put(0L, 1L);
        
        for(int i =0 ; i<n; i++){
            int num = nums.get(i);
            if(num % modulo  == k){
                prefix++;
            }
            
            prefix %= modulo;
            
            long target = (prefix - k + modulo) % modulo;
            ans += mp.getOrDefault(target,0L);
            
            mp.put(prefix, mp.getOrDefault(prefix, 0L) + 1);
        }
        return ans;
    }
}