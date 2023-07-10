/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
   
    static ListNode findCycleNode(ListNode head, ListNode slow, ListNode fast) {
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode detectCycle(ListNode head) {
       ListNode slow = head;
        ListNode fast = head;
        while(fast  != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return findCycleNode(head, slow, fast);
            }
        }
        return null;
    }
}