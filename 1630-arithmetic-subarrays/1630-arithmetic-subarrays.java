class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> al = new ArrayList<>();
        for(int i = 0 ; i < l.length ; i++){
            int si = l[i];
            int ei = r[i];
            int [] arr = new int[ei-si+1];
            for(int j = si ; j <= ei ; j++){
                arr[j-si] = nums[j];
            }
            Arrays.sort(arr);
            int cd = arr[1] - arr[0];
            int k = 0;
            for(k = 1 ; k < arr.length ; k++){
                if(arr[k] - arr[k-1] != cd){
                    al.add(false);
                    break;
                }
            }
            if( k == arr.length){
                al.add(true);
            }
        }
        return al;
    }
}