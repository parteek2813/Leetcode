class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            int x2 = points[i + 1][0], y2 = points[i + 1][1];
            seconds += Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
        return seconds;
    }
}