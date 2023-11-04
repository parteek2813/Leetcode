class Solution {
public:
    int findKOr(vector<int>& nums, int k) {
         
        int ans = 0;
        
        // go on every bit and 0 - 31
        // for every bit, we will go on to every num
        // if that bit is set- count++ -> if count >= k, include that bit in ans (2*i);
        
        for(int i =0; i<= 31; i++){
            
            int count = 0;
            
            for(auto el : nums){
                if(el & (1<<i)){
                    count++;
                }
            }
            
            if(count >= k){
                ans += (1<<i);  // from this line, we are adding 2*i in our ans
            }
            
            
        }
        return ans;
    }
};