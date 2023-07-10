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
        k = k% n; // updating k acc. to point 5
        while(k-- > 0){
            ListNode y = head;
            int preValue = y.val;

            y = y.next; // starting from 2nd node
            while( y != null ){
                // swapping x.val with preValue
                int temp = y.val;  
                y.val = preValue;
                preValue = temp;

                y= y.next;
            }
            head.val = preValue; //updating 1st node value to last
        }
        return head;
    }
}