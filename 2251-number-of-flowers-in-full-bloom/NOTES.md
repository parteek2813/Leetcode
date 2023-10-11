//     public static int[] fullBloomFlowers(int[][] flowers, int[] people){
​
//         // iterate over people array and keep count of person whose start < target
​
//         int n = people.length;
// int[] result = new int[n];
​
//         for(int i =0; i<n; i++){
​
//             int target = people[i];
//             int count = 0;
​
//             // Count flowers that are in full bloom when the person arrives
//             for(int j =0; j<flowers.length; j++){
//                 if(flowers[j][0] <= target && flowers[j][1] >= target){
//                     count++;
//                 }
//             }
//             result[i] = count;
//         }
​
//         return result;
//     }