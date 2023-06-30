class Solution {
public int minimumTimeRequired(int[] jobs, int k) {
    int left = 0;
    int right = 0;
    for (int job : jobs) {
        left = Math.max(left, job);
        right += job;
    }

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (isPossible(jobs, k, mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}

private boolean isPossible(int[] jobs, int k, int maxTime) {
    int[] workers = new int[k];
    return backtrack(jobs, workers, 0, maxTime);
}

private boolean backtrack(int[] jobs, int[] workers, int index, int maxTime) {
    if (index == jobs.length) {
        return true;
    }

    for (int i = 0; i < workers.length; i++) {
        if (workers[i] + jobs[index] <= maxTime) {
            workers[i] += jobs[index];
            if (backtrack(jobs, workers, index + 1, maxTime)) {
                return true;
            }
            workers[i] -= jobs[index];
        }

        if (workers[i] == 0 || workers[i] + jobs[index] == maxTime) {
            break;
        }
    }

    return false;
}

}