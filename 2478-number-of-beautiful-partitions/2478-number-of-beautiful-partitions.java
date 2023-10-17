class Solution {
    private static final int MOD = 1_000_000_007;

    Set<Character> primes = Set.of('2', '3', '5', '7');
    int n;

    public int beautifulPartitions(String s, int k, int minLength) {
        n = s.length();
        if(primes.contains(s.charAt(s.length() - 1))) return 0;
        if(!primes.contains(s.charAt(0))) return 0;
        int[][] dp = new int[s.length() + 1][k];
        for(int[] A : dp) Arrays.fill(A, -1);
        return numOfWays(dp, 0, k - 1, s, minLength);
    }

    private int numOfWays(int[][] dp, int index, int cutsLeft, String s, int minLength) {
        if(cutsLeft == 0) {
            if(n - index >= minLength) return 1;
            return 0;
        }
        if(dp[index][cutsLeft] != -1) return dp[index][cutsLeft];

        int res = 0;
        for (int i = index; i < n - cutsLeft; i++) {
            if(i + (minLength * (cutsLeft - 1)) >= n) break; // must make that optimization to AC.
            
            if(!primes.contains(s.charAt(i)) && primes.contains(s.charAt(i + 1))) {
                if(i - index + 1 >= minLength) {
                    res = (res  + (numOfWays(dp, i + 1, cutsLeft - 1, s, minLength) % MOD)) % MOD;
                }
            }
        }

        return dp[index][cutsLeft] = res;
    }
}