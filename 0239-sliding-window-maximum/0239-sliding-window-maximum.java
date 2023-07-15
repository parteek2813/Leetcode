class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new LinkedList<>();

        int n = nums.length;
        int[] arr = new int[n-k+1];
        
        for(int i =0; i<k; i++){
            
            // remove smaller elements
            while(!dq.isEmpty() && nums[i]>= nums[dq.peekLast()]){
                dq.removeLast();
            }


            dq.addLast(i);
        }

        // for remaining elements
        // max element is always at front of the deque
        int windowIndex=0;
        
        for(int i =k ; i<= n-1; i++){
             arr[windowIndex++] = nums[dq.peekFirst()];



            // remove elements from front whose indices outside the window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }

            // remove smaller element from back before pushing curr element

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }

            // add curr element now
            dq.addLast(i);
        }
        
        arr[windowIndex] = nums[dq.peekFirst()];
        return arr;
    }
   
}