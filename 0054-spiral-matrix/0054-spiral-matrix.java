class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = matrix.length;
        int m = matrix[0].length;
        
        
        int rB = 0;
        int cB = 0;;
        
        int rE = l-1;
        int cE = m-1;
        
        List<Integer> list = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 ||                   matrix[0].length == 0) {
            return list;
        }
        
        while(rB <= rE && cB <= cE ){
            
//             traverse right
            for(int j=cB; j<=cE; j++){
                list.add(matrix[rB][j]);
            }
            
            rB++;
            
//             traverse down
            for(int j=rB; j<= rE; j++){
                 list.add(matrix[j][cE]);
            }
            
            cE--;
            
//             traverse left
            if (rB <= rE){
                for (int j=cE; j>= cB; j--){
                    list.add(matrix[rE][j]);
                }
            }
            
            rE--;
            
//             traverse up
            if(cB <= cE){
                for(int j=rE; j>=rB; j--){
                     list.add(matrix[j][cB]);
                }
            }
            
            cB++;
            
        }
            
        return list;
    }
}