class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        int n=0,count=0;
        for(Map.Entry<Integer,Integer> x: h.entrySet()){
            if(x.getValue()<2) return -1;
            if(x.getValue()%3==0){
                count+=x.getValue()/3;
                n+=x.getValue();
            }
            else if(x.getValue()%3==2){
                count+=x.getValue()/3+1;
                n+=x.getValue();
            }
            else if(x.getValue()%3==1){
                count+=(x.getValue()/3-1)+2;
                n+=x.getValue();
            }
        }
        return count;
    }
}