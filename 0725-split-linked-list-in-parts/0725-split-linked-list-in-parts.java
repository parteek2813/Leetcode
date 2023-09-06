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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];

        int len =0;
        
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // declare n and k
        int n = len/k;
        int r = len % k;
        
        temp = head;
        
        // iterate
        for(int i =0; temp != null && i < k; i++, r--){
            parts[i] = temp;
            for(int j =0; j< n+ (r>0 ? 1 : 0); j++){
                head = temp;
                temp = temp.next;
                
            }
            
            // if prev is not null, when one part is over
            if( head != null){
                head.next = null;
            }
        }
        
        return parts;
        
    }
}