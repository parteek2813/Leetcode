class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        
        for( int i =0; i<nums.length; i++){
            int sq = (int)Math.sqrt(nums[i]);
            
            for( int j=2 ; j<=sq; j++){
                if(nums[i] % j ==0){
                    
                    
                    hm.add(j);
                    while(nums[i] % j ==0){
                        nums[i] = nums[i]/j;
                    }
                }
            }
            
            // Just add it in the hashset 
            if(nums[i] > 1){
                hm.add(nums[i]);
            }
        }
        
        return hm.size();
        
        
    }
}