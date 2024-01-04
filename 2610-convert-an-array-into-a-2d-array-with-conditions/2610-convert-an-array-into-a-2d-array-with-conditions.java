class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length];
        List<List<Integer>> res = new ArrayList();
        for(int i=0;i<nums.length;i++){
            freq[nums[i]-1]++;
            if(freq[nums[i]-1]>res.size()){
                List<Integer> newRow = new ArrayList();
                newRow.add(nums[i]);
                res.add(newRow);
            }else{
                List<Integer> existingRow = res.get( (freq[nums[i]-1]-1) );
                existingRow.add(nums[i]);
            }
        }
        return res;
    }
}