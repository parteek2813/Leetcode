class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap();
        
        
        for(int num: nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        
        int[] result = new int[n1];
        for(int i=0; i<n1; i++){
            result[i] = map.get(nums1[i]);
            
            }
        
        return result;
    }
}