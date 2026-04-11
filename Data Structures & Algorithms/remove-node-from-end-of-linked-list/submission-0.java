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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next =head;
        ListNode first = sentinel , second = sentinel;
        for(int pos=0; pos <=n; pos++){
            second = second.next;
        }
        while(second!=null){
            first = first.next;
            second = second.next;
        }

        //now the next to current first is the one to be remopved
        first.next = first.next.next;

        return sentinel.next;
    }
}
