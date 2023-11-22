class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        int n = 0, i = 0, maxKey = 0;

        // same diagonal elements have equal sum
        Map<Integer, List<Integer>> map = new HashMap();

        // bottom rows contain starting values of the diagonals
        for (int r = nums.size() - 1; r >= 0; r--) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                map.putIfAbsent(r + c, new ArrayList());
                map.get(r + c).add(nums.get(r).get(c));
                // no of diagonals or groups of nos
                maxKey = Math.max(maxKey, r + c);
                // count of elements for res array size
                n++;
            }
        }

        int[] ans = new int[n];
        for (int key = 0; key <= maxKey; key++) {
            List<Integer> value = map.get(key);
            for (int v : value)
                ans[i++] = v;
        }
        return ans;
    }
}