class Solution {
    public int trap(int[] height) {
        
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int max =0;
        int water =0;
        
        // creating a leftMax array sum
        leftMax[0] = height[0];
        for(int i =1; i<n; i++){
               leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        }
        
         // creating a rightMax array sum
        rightMax[n - 1] = height[n - 1];
        for(int j =n-2; j>=0; j--){
           rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        
        // cal water accumulated
        
        for( int i=0; i<n; i++){
            water = water + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
}