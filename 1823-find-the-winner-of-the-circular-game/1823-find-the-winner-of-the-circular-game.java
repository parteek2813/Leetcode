class Solution {
    
    
    // METHOD USING QUEUE
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        
        // store all elem in queue
        for(int i =1; i<=n; i++){
            q.add(i);
        }
        
        while(q.size() > 1){
            int deleteCount = k-1;
            while(deleteCount >0){
                q.add(q.poll()); // rotate elements
                deleteCount--;
            }
            
            q.poll();
            
        }
        return q.poll();
        
    }
    
    // simple recursion to apply for 
//     public static int helper(int n , int k){
//         if(n==1){
//             return 0;
//         }else{
//             return (helper(n-1, k) + k) % n;
//         }
            
//     }
//     public int findTheWinner(int n, int k) {
//         return helper(n, k) +1;
        
//     }
    
    
}