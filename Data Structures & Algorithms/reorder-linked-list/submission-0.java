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
    public void reorderList(ListNode head) {
         //To Reorder the list
        ListNode sentinel = new ListNode();  
        sentinel.next = head;
         //finding the middle node  
        ListNode slow=head,fast=head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //here slow points to the second half of the list , now reverse it
        ListNode current = slow.next;
        slow.next = null; // Break the link between first and second half ; and from nnow current pointer takes over
        ListNode prev=null, next=null;
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev= current;
            current = next;
        }
        //here prev points to the head of reversed list , now merge the two lists
        ListNode first = head, second = prev;
        while(second !=null){ //checking only second as this will always be shortedor equal
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second; //linkinf firsdt to second
            second.next = temp1;
            first = temp1;
            second = temp2;
        } 
    }
}
