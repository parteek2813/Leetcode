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
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count = count +1;
            temp = temp.next;
        }
        return count;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case
      
        while(getLength(head) < k){
            return head;
        }
        
        // rec case
        ListNode prev = null;
        ListNode current = head;
        int count =0;
        while(count< k){
            ListNode N = current.next;
            current.next = prev;
            prev = current;
            current = N;
            count++;
            
        }
        if(current != null){
            head.next = reverseKGroup(current, k);
        }
        return prev;
    }
}