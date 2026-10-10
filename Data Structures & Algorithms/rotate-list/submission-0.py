# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return head
        n = 1
        curr = head
        while curr.next:
            curr = curr.next
            n += 1
        end = curr

        k %= n
        if k == 0:
            return head
        
        end.next = head
        newTail = head
        for _ in range(n - k - 1):
            newTail = newTail.next

        newHead = newTail.next
        newTail.next = None
        return newHead
        