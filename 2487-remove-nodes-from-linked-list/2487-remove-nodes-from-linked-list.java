/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode runner = head;
        
        // Add all ListNode.Val in arraylist first
        while(runner != null){
            nums.add(runner.val);
            runner = runner.next;
        }
        
        HashMap<Integer, Boolean> hm = new HashMap<>();
        
        Stack<Pair<Integer,Integer>> pq = new Stack<>();
        
        // push the first element
        pq.push(new Pair<>(nums.get(0),0));
        
        
        for(int i =1; i<nums.size(); i++){
            while(!pq.isEmpty() && pq.peek().getKey() < nums.get(i)){
                Pair<Integer, Integer> temp = pq.pop(); // pop this element
                
                hm.put(temp.getValue(), true); // store this in hashmap iteself for reference at last
                
            }
                    pq.push(new Pair<>(nums.get(i), i));

        }
        
        
        // Actual manipulation in LL here
        ListNode runner2 = head;
        ListNode prev = null;
        
        // if there is false , that means uske pehle ko head bnao
        for(int i =0; i<nums.size(); i++){
            if(!hm.containsKey(i)){
                runner2.val = nums.get(i);
                prev = runner2;
                runner2 = runner2.next;
                
            }
        }
        
        if( prev != null){
            prev.next = null;
        }
        
        return head;
        
    }
}