class Solution {
    public char findKthBit(int n, int k) {
        return findKthBit(k); // n is irrelevant
    }
    
    public char findKthBit(int k) {
        if(k == 1)
            return '0';
        if((k & (k-1)) == 0) // k is a power of 2
            return '1';
        return findKthBit(upper(k) - k) == '0' ? '1' : '0';
    }
    
    private static int upper(int k){
		// Find the smallest power of 2 greater than k
		// E.g., if k = 1, return 2.
		// If k = 2 or k = 3, return 4.
		// If 4 <= k <= 7, return 8.
        int mask = 0x80000000, c = 0;
        while((mask & k) == 0){
            ++c;
            k <<= 1;
        }
        return mask >>> (c-1);
    }
}