class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        
        int[] r = new int[n-k+1];
        
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        
        while(i<n){
            
            // remove the fisrt element jo size se jyada aa rha ya bhokh rahe
            while(!q.isEmpty() && q.peekFirst() <= i-k){
                q.pollFirst();
            }
            
            
            // queue ke peeche wala element jo nums[i] se chote hein unhe remove kardo
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            
        
            q.offerLast(i);
            
            // one by one r array me push karte jao kyuki deque me we can add or remove from any 
            // side and mind you that dequeu me sorted order me hi hoga. only.
            
            if(i >= k-1){
                r[i-k+1] = nums[q.peekFirst()];
            }
            
            i++;
            
            
            
        }
        return r;
        
    }
}