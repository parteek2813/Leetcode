class Solution {
public:
    bool isPowerOfFour(int n) {
//         if(n <= 0){
//             return 0;
//         }
        
        
//         int x = (log(n) / log(4));
        
//         if(pow(4,x) == n){
//             return true;
//         }
        
//         return false;
        
        // APPROACH 3
        
        if(n <= 0){
            return 0;
        }
        
        if((n&(n-1)) == 0 && (n-1)%3 == 0){
            return true;
        }
        
        return false;
    }
};