// import java.util.PriorityQueue;


// REVIEW THIS CODE AFTERWARDS

// class Solution {
//     public int minimumOperations(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         int minElement = Integer.MAX_VALUE;
//         boolean hasZero = false;

//         // Calculate the sum and find the minimum element in the array
//         for (int num : nums) {
//             sum += num;
//             minElement = Math.min(minElement, num);
//             if(num ==0){
//                 hasZero = true;
//             }
//         }
        
//         if(minElement == 0){
//             return hasZero ? n-1: n;
//         }

//         // Calculate the number of operations needed to make all elements zero
//         // Subtracting minElement from all elements will make them equal to zero
//         int cnt = n * Math.abs(minElement) - sum;

//         return cnt;
//     }
// }



class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // add into the queue 
        for(int num: nums){
            pq.offer(num);
        }
        
        int cnt=0;
        int current = pq.poll();
        
        
        // if current not zero, increment count
        if(current != 0){
            cnt++; 
        }
        
        //
        while(pq.size() >0){
            int tmp = pq.poll(); // next element
            if(tmp != current && tmp != 0){
                cnt++;
                current = tmp;
            }
        }
        
        return cnt;
        
    }
}