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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode x = head; // creating copy of head in x to iterate the list while keeping the head unchanged
        if( x == null || k==0) return head; // if list is empty or if we don't have to rotate the list, return it
        int n = 1;  // counting no. of nodes in the list 
        while( x.next != null){
            x = x.next;
            n++;
        }
        int i = 1;
        k = k%n;  // updaing k acc. to point 5
        if(k==0 || n==1) return head; // list will not change in this case, so just return it
        ListNode y = head;
        while( i < n-k ){
            y = y.next;
            i++;
        }
        ListNode newHead = y.next; // Creating a new head point which points to (n-k)th node
        y.next = null;   // pointing the (n- k-1)th node to null
        x.next = head; // pointing the last pointer to first node.
        
        return newHead;
    }
}