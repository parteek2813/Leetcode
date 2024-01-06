class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = endTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));

        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            int start = jobs[i][0];
            int end = jobs[i][1];
            int prof = jobs[i][2];

            int accumulatedClosestEnd = binarySearch(jobs, start);
            dp[i + 1] = Math.max(dp[i], prof + dp[accumulatedClosestEnd]);
        }

        return dp[n];
    }

    private int binarySearch(int[][] jobs, int key) {
        int low = 0;
        int high = jobs.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (jobs[mid][1] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}