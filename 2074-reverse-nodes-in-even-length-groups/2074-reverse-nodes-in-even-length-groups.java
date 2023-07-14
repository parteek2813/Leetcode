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
    
    // declaring reverse function here

    static ListNode reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode next = start;
        
        while(start != end){
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        
        return prev;
    }
    
    
    static ListNode findEven(ListNode head, int prevLen){
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode tail = head;
        int len =0;
        
        
        // skipping part here
        while(curr != null && len<prevLen){
            tail = curr;
            curr = curr.next;
            len++;
        }
        
        // if even then reverse otherwise don't
        if(len%2 == 0){
            ListNode newHead = reverse(head,curr);
            head.next = findEven(curr, len+1);
            return newHead;
        }
        
        // if odd
        tail.next = findEven(curr, len+1);
        return head;
        
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        return findEven(head,1);
    }
}