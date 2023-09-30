class Solution {
    
    // Rough
    // brute force
    /*
    
    // SIMPLE FOR LOOP
    
    boolean found = false;
    
    for(int i =0; i<n; i++){
        for(int j=1; j<n-1; j++){
            for(int k=2; k<n-2;i++){
            if this condition met
            found = true;
            break;
            }
        }
    }
    return found;
    
    
    // ANY OTHER APPROACH
    
    // No SORTING (No Binary Search)
    // 
    
    
    
    Recursive Calls: The function solve(nums, index, ans, dp) is called multiple times in a recursive manner. In the        worst case, it explores all possible combinations of elements in the input array nums. For each element, there are      two recursive calls (pick and not pick). This results in a branching factor of 2.
    
    
    Recursion Depth: The recursion depth is at most n, where n is the length of the input array nums. At each level of      the recursion, the function explores two branches.
    
    
    */
    
    /*
    
    Approach Second. Go to every array element and check previous and next element and it 
    condition satisfied then done.But this is subsequence not subarray so won't Work here.
    
    */
    
    /*
    
    Stack Based Approach
    
    */
    
    
    
    // Taking more time, SO DP would not work here.
    
    public static boolean findThePattern(int[] nums, int index, List<Integer> ans, boolean[] dp){
        
        if(index >= nums.length || ans.size() == 3){
            if(ans.size() == 3 && ans.get(0) < ans.get(2) && ans.get(2) < ans.get(1)){
                return true;
            }
            return false;
        }
        
        
        // dp logic
        if(dp[index]){
            return false;
        }
        
        // PICK
        ans.add(nums[index]); // ans = [1]
        boolean left = findThePattern(nums, index + 1, ans, dp);
        ans.remove(ans.size()-1);
        
        // NOT PICK
        boolean right = findThePattern(nums, index+1, ans, dp);
        
        dp[index] = left || right; // in any of them, whereever the true Comes becomes the final answer.
        return dp[index];
        
    }
    
    public static boolean findPatternStack(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            
            // Two condition are satisfied in if and while condtion ... in if it is nums[i] < max (Lowest wala)
            if(nums[i] < max){
                return true;
            }
            
            while(!stack.isEmpty() && nums[i] > stack.peek()){ 
                
                // nums[i] > stack pushed element (Highest wala)
                max = stack.pop();
            }
            
            stack.push(nums[i]); 
            
            // STACK  max = min_value
            // 2      max = 2
            // 4
        }
        
        return false;
    }
    
   
    
    public boolean find132pattern(int[] nums) {
        // boolean res = findThePattern(nums, 0 , new ArrayList<>(), new boolean[nums.length]);
        // return res;
        
        
        boolean res = findPatternStack(nums);
        return res;
    }
}