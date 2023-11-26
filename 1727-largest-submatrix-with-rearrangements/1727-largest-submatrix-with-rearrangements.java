class Solution
 {
   
  
  public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = 0;
        
       
     for (int row = 0; row < m; row++) {
                // Iterate through each column of the current row
                for (int col = 0; col < n; col++) {
                    // If the current element is not zero and the row is greater than 0

     if (matrix[row][col] != 0 && row > 0) {
                        // Update the current element by adding the value of the element above it
                        matrix[row][col] += matrix[row - 1][col];
                    }
                }

            // Create a copy of the current row and sort it in ascending order
           
 int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            
            // Iterate through the sorted row in reverse order
            for (int i = 0; i < n; i++) {
                // Update the result by taking the maximum of the current result and
                // the product of the current element in the sorted row and the width of the submatrix
                ans = Math.max(ans, currRow[i] * (n - i));
            }
        }
        
        // Return the final result
        return ans;
    }
}
