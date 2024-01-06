class Solution {

    int cnt;

    private int solve(int[] tops, int[] bottoms) {

        for(int i=1;i<=6;i++) {

            int sum = 0;
            int j = 0;

            for(;j<tops.length;j++) {

                if(tops[j] != i && bottoms[j] != i) {

                    break;
                }
                else if(tops[j] != i && bottoms[j] == i)
                    sum++;

            }

            if(j == tops.length)
                cnt = Math.min(cnt, sum);

        }

        return cnt;

    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        cnt = Integer.MAX_VALUE;

        cnt = solve(tops, bottoms);

        cnt = solve(bottoms, tops);

        return cnt == Integer.MAX_VALUE ? -1 : cnt;


    }
}