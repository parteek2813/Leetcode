class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // count the number of 1's in each row and then sort them in ascending order
        // and then get the first k elements
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[] res_arr = new int[n];
        
        for(int i =0; i<n; i++){
            int cnt =0;
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    cnt++;
                }
            }
            res_arr[i] = cnt;
        }
        
        
        // initialize a pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (res_arr[a] == res_arr[b]) {
                return a - b;
            }
            return res_arr[a] - res_arr[b];
        });
        
        // store the indices not the element
        for(int i=0; i<n; i++){
            pq.add(i);
        }
        
        // transfer from the pq to the result array to return it
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        
        return result; 

        
    }
}