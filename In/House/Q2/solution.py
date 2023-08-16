# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    @classmethod
    def of(cls, lst):
        h = None
        t = None
        for item in lst:
            if h is None and t == None:
                h = t = ListNode(item)
            else:
                t.next = ListNode(item)
                t = t.next
        return h
    @classmethod
    def show(cls, listnode):
        while listnode is not None:
            print(listnode.val, end="")
            listnode = listnode.next
        print()

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        flag = False
        head = tail = ListNode(-1)
        while l1 is not None and l2 is not None:
            tmp = l1.val + l2.val + (1 if flag else 0)
            flag = True if tmp > 9 else False
            tail.next = ListNode(tmp % 10)
            tail = tail.next
            l1 = l1.next
            l2 = l2.next
        while l1 is not None:
            tmp = l1.val + (1 if flag else 0)
            flag = True if tmp > 9 else False
            tail.next = ListNode(tmp % 10)
            tail = tail.next
            l1 = l1.next
        while l2 is not None:
            tmp = l2.val + (1 if flag else 0)
            flag = True if tmp > 9 else False
            tail.next = ListNode(tmp % 10)
            tail = tail.next
            l2 = l2.next
        if flag is True:
            tail.next = ListNode(1)
        return head.next

# ListNode.show(Solution().addTwoNumbers(ListNode.of([2, 4, 3]), ListNode.of([5, 6, 4])))

# ListNode.show(Solution().addTwoNumbers(ListNode.of([0]), ListNode.of([0])))

# ListNode.show(Solution().addTwoNumbers(ListNode.of([9, 9, 9, 9, 9, 9, 9]), ListNode.of([9, 9, 9, 9])))

# ListNode.show(Solution().addTwoNumbers(ListNode.of([2, 4, 9]), ListNode.of([5, 6, 4, 9])))
