class Solution {
    public int totalMoney(int n) {
        return sol(n, 0);
    }

    int sol(int n, int i) {
        if (n <= 7) return n*i + n * (n + 1) / 2;
        return 7*i + 28 + sol(n-7, i+1);
    }
}