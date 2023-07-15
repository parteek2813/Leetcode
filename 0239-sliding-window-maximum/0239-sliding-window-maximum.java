// USING QUEUE:



// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
        
//         Deque<Integer> dq = new LinkedList<>();

//         int n = nums.length;
//         int[] arr = new int[n-k+1];
        
//         for(int i =0; i<k; i++){
            
//             // remove smaller elements
//             while(!dq.isEmpty() && nums[i]>= nums[dq.peekLast() ]){
//                 dq.removeLast();
//             }


//             dq.addLast(i);
//         }

//         // for remaining elements
//         // max element is always at front of the deque
//         int windowIndex=0;
        
//         for(int i =k ; i<= n-1; i++){
//              arr[windowIndex++] = nums[dq.peekFirst()];



//             // remove elements from front whose indices outside the window
//             while(!dq.isEmpty() && dq.peekFirst() <= i-k){
//                 dq.removeFirst();
//             }

//             // remove smaller element from back before pushing curr element

//             while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
//                 dq.removeLast();
//             }

//             // add curr element now
//             dq.addLast(i);
//         }
        
//         arr[windowIndex] = nums[dq.peekFirst()];
//         return arr;
//     }
   
// }



// USING PRIORITY QUEUE:
// TIME LIMIT EXCEEDED ERROR : TAKEN O(NK) TIME

// public class Solution {
// public int[] maxSlidingWindow(int[] nums, int k) {
//     int len = nums.length;
//     int[] result = new int[len - k + 1];
//     if(nums.length == 0) return new int[0];
//     Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
//         @Override
//         public int compare(Integer i1, Integer i2){
//             return Integer.compare(i2, i1);
//         }
//     });
    
//     for(int i = 0; i < k; i ++){
//         queue.add(nums[i]);
//     }
//     result[0] = queue.peek();
//     for(int i = k; i < len; i ++){
//         queue.remove(nums[i - k]);
//         queue.add(nums[i]);
//         result[i - k + 1] = queue.peek();
//     }
   
//     return result;
//     }
// }



// USING TREE MAP:
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};
        // implement a treemap to save the entry <nums[i], i>
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
        	
        // the maxWindow to save the largest in sliding window with width k
        int[] maxWindow = new int[nums.length - k + 1];
        
        
        for (int i = 0; i < nums.length; i++) {
        	// for i < k, just put the entries to the tree because there are not enough entries
        	tree.put(nums[i], i);

        	// if i >= k - 1, meaning that there are k elements in the window
        	if (i >= k - 1) {
        		// get the last (largest) key of the tree and put it into the max array
        		maxWindow[i - k + 1] = tree.lastKey();
        		// since there are enough entries, we need to remove the oldest one
        		// however, there may exist duplicates
        		// thus we need to check whether the index matches
        		// if matches, just remove it safely
        		// if not match, meaning that the number is automatically covered by some later numbers and we don't need to remove it
           		if (tree.get(nums[i - k + 1]) == i - k + 1) { tree.remove(nums[i - k + 1]); }
                }
         }

        return maxWindow;
    }
}