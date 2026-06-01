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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int val1 = 0; int val2 = 0;
            if(l1 != null) {
                val1 = l1.val;
            } else {
                val1 = 0;
            }

            if(l2 != null) {
                val2 = l2.val;
            } else {
                val2 = 0;
            }

            int newVal = val1 + val2 + carry;
            carry = newVal / 10;
            newVal = newVal % 10;
            curr.next = new ListNode(newVal);

            if(l1 != null) {
                l1 = l1.next;
            } 
            if(l2 != null) {
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
