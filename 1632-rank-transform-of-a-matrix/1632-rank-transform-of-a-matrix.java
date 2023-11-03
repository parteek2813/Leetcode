class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] idx = IntStream.range(0, m*n).boxed().sorted(Comparator.comparingInt(o -> matrix[o/n][o%n])).mapToInt(o->o).toArray(); // sort by value 
        int[] row = new int[m]; // previous identical number's index for a given row
        int[] col = new int[n];  // previous identical number's index for a given col
        int[] rowMin = new int[m]; // min row rank 
        int[] colMin = new int[n]; // min col rank
        int[][] ans = new int[m][n];
        UF uf = new UF(m*n);
        Arrays.fill(row, -1); // at first, no valid index is present
        Arrays.fill(col, -1);
        for (int i = 0, j = 0; i < m*n; i++){
            int a = idx[i]/n, b = idx[i]%n;
            uf.union(idx[i], row[a]); // union with previous identical number's index for row
            uf.union(idx[i], col[b]); // and for col
            uf.updateRank(idx[i], Math.max(rowMin[a], colMin[b])+1); // update the rank
            row[a]=col[b]=idx[i]; // update itself to row & col for future identical number
            if (i==m*n-1 || matrix[a][b] != matrix[idx[i+1]/n][idx[i+1]%n]){ // we are at the end of identical numbers, process all the groups now.
                for (int k = j; k <= i; k++){
                    int x = idx[k]/n, y = idx[k]%n;
                    rowMin[x]=colMin[y]=ans[x][y]=uf.getRank(idx[k]); // get the rank from uf and assign it to all relevant info
                    row[x] = col[y] = -1; // backtrack row & col index info.
                }
                j = i+1; // update j (start pointer)
            }
        }
        return ans;
    }
    
    private class UF {
        int[] parent;
        int[] rank;
        int[] min;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
            min = new int[n];
        }
        int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }
        void union(int x, int y){
            if (x < 0 || y < 0 || find(x) == find(y)){
                return;
            }
            x = find(x); y = find(y);
            if (rank[x] > rank[y]){
                parent[y]=x;
                min[x]=Math.max(min[y], min[x]);
            }else{
                parent[x]=y;
                min[y]=Math.max(min[y], min[x]);
                if (rank[x] == rank[y]){
                    rank[y]++;
                }
            }
        }
        void updateRank(int x, int val){
            min[find(x)] = Math.max(val, min[find(x)]);
        }
        int getRank(int x){
            return min[find(x)];
        }
    }
}