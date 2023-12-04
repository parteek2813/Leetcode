public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cout=0;
        while(n!=0){
            
             n=n & n-1;
                cout++;


            }
        return cout;
    }
}