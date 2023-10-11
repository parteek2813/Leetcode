class Solution {

    
    public static int[] fullBloomFlowers(int[][] flowers, int[] people){
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];


        // storing the first and end of each pair in seprate array
        for(int i =0; i<n; i++){
            start[i] =flowers[i][0];
            end[i] = flowers[i][1];
        }


        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[people.length];



        for(int i =0; i<people.length; i++){
            int target = people[i];
            int started = binarySearchUpperBound(start,target);
            int ended = binarySearchLowerBound(end,target);
            res[i] = started - ended;
        }

        return res;
    }

    public static int binarySearchUpperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int binarySearchLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}