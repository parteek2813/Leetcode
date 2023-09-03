// public class Solution {
// public int uniquePaths(int m, int n) {
//     int[][] grid = new int[m][n];
//     for(int i = 0; i<m; i++){
//         for(int j = 0; j<n; j++){
//             if(i==0||j==0)
//                 grid[i][j] = 1;
//             else
//                 grid[i][j] = grid[i][j-1] + grid[i-1][j];
//         }
//     }
//     return grid[m-1][n-1];
// }
// }


// Using DP
class Solution {
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        int[][]dp = new int[m+1][n+1];
        for(int x=m;x>=0;x--){
            for(int y=n;y>=0;y--){
                if(x == m || y == n) dp[x][y] = 0;
                else if(x == m-1 && y == n-1) dp[x][y] = 1;
                else dp[x][y] =  dp[x+1][y] + dp[x][y+1]; 
            }
        }
        return dp[0][0];
    }
}