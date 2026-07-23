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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val)); 
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        ListNode curr = dummy;
        while(!minHeap.isEmpty()) {
            ListNode poll = minHeap.poll();
            curr.next = poll;
            curr = curr.next;
            if(poll.next != null) {
                minHeap.offer(poll.next);
            }
        }


        return dummy.next;
    }
}
