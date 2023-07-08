class Solution {
    public long putMarbles(int[] weights, int k) {
        
       int n = weights.length;
        // for storing the difference here
        int[] candidates= new int[n-1];
        
        for(int i =0; i<n-1; i++){
            candidates[i] = weights[i] + weights[i+1]; // takin each consecutive elemn sum here
        }
        
        Arrays.sort(candidates);
        long min_sum =0;
        long max_sum = 0;
        
        for(int i =0; i<k-1; i++){
            min_sum += candidates[i]; // starting k-1 arr
            max_sum += candidates[n-i-2];
            
        }
        return max_sum - min_sum;
    }
}

