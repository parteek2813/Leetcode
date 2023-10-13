class Solution {
    
    public static void swap(int[][] matrix, int i, int j, int p, int q) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = temp;
    }
    
    public static void reverse(int[][] matrix, int n ){  
        int p1 = 0;
        int p2 = n - 1;

        while (p1 < p2) {
            for (int i = 0; i < n; i++) {
                swap(matrix, i, p1, i, p2);
            }
            p1++;
            p2--;
        }     
    }
    
    
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        


	    // here transposing the matrix
        for(int i =0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                 swap(matrix, i, j, j, i);
            }
        }

	    // reversing the matrix
	   reverse(matrix,n);  
       
        // Print the rotated matrix (optional)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    

}