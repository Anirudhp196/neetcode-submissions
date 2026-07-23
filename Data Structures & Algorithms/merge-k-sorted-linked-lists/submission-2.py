# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minHeap = []
        
        for list in range(len(lists)):
            if lists[list] is not None:
                heapq.heappush(minHeap,
                    (
                        lists[list].val,
                        list,
                        lists[list]
                    )
                )

        dummy = ListNode()
        curr = dummy

        while minHeap:
            value, list, smallestNode = heapq.heappop(minHeap)
            curr.next = smallestNode
            curr = curr.next
            if smallestNode.next is not None:
                heapq.heappush(
                    minHeap,
                    (
                        smallestNode.next.val,
                        list,
                        smallestNode.next
                    )
                )

        
        return dummy.next
        