class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // create new 2d array
        int[][] newArr = new int[m][n];

        newArr[0][0] = grid[0][0];

        // traverse rows and cal row sum firs
        for(int i =1; i<m; i++){
            newArr[i][0] =  newArr[i-1][0] + grid[i][0];
        }

         // traverse cols and cal row sum firs
        for(int j =1; j<n; j++){
            newArr[0][j] =  newArr[0][j-1] + grid[0][j];
        }

    // prefix sum array completed

    for( int i =1; i<m; i++){
        for( int j=1; j<n; j++){
            newArr[i][j] = grid[i][j] + Math.min(newArr[i-1][j], newArr[i][j-1]);
        }
    }

    return newArr[m-1][n-1];
    }
}