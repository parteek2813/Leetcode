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




// *** DIVIDE AND CONQUER APPROACH! ***

// class Solution {
    
//     private ListNode mergeList(ListNode n1, ListNode n2){
//         ListNode dummy = new ListNode(-1);
//     ListNode prev = dummy;
//     while (n1 != null && n2 != null) {
//         if (n1.val < n2.val) {
//       prev.next = n1;
//       n1 = n1.next;
//     } else {
//       prev.next = n2;
//       n2 = n2.next;
//     }
//     prev = prev.next;
//   }
//   prev.next = (n1 != null) ? n1 : n2;

//   return dummy.next;
//     }
    
    
//     private ListNode divideAndConquer(ListNode[] lists, int lo, int hi) {
//         if (lo > hi) { // invalid
//             return null;
//         }
//         if (lo == hi) { // size = 1
//             return lists[lo];  // this is the main base case for solving this
//         }
//             int mid = lo + (hi - lo) / 2; // left-leaning
//             ListNode left = divideAndConquer(lists, lo, mid);
//             ListNode right = divideAndConquer(lists, mid + 1, hi);
//              return mergeList(left, right);
//         }
    
    
    
//         public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) {
//             return null;
//          }
//         return divideAndConquer(lists, 0, lists.length - 1);
//     }
// }


class Solution {

public ListNode mergeKLists(ListNode[] lists) {
  if (lists == null || lists.length == 0) {
    return null;
  }
  // Use the 0-th list as a return list
  for (int i = 1; i < lists.length; ++i) {
    lists[0] = mergeList(lists[0], lists[i]);
  }

  return lists[0];
}

private ListNode mergeList(ListNode n1, ListNode n2) {
  ListNode dummy = new ListNode(-1);
  ListNode prev = dummy;
  while (n1 != null && n2 != null) {
    if (n1.val < n2.val) {
      prev.next = n1;
      n1 = n1.next;
    } else {
      prev.next = n2;
      n2 = n2.next;
    }
    prev = prev.next;
  }
  prev.next = (n1 != null) ? n1 : n2;

  return dummy.next;
    }
    
}