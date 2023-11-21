class Solution {
    private int mod = (int)1e9+7;
    public int countNicePairs(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        for(int num: nums){
            
            int temp = num-rev(num);
            int pairs = map.getOrDefault(temp,0);
            if(pairs!=0){
                answer=(answer+pairs)%mod;
            }
            
            map.put(temp,pairs+1);
        }
        
        
        return answer;
    }
    
    private int rev(int x){
        int ans = 0;
        while(x>0){
            ans*=10;
            ans+= x%10;
            x/=10;
        }
        
        return ans;
    }
    
    
    
}