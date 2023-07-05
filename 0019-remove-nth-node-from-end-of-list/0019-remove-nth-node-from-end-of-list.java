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
    
    static int getLength(ListNode head){
        ListNode temp= head;
        int count =0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
        
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = getLength(head);
        int targetIndex = length - n;

        ListNode temp = dummy;
        for (int i = 0; i < targetIndex; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return dummy.next;
    }

}