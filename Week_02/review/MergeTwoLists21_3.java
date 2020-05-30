package review;

import java.util.LinkedList;

public class MergeTwoLists21_3 {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        return _func1Recursive(l1,l2);
        return _func2Iterate(l1,l2);
    }

    private ListNode _func2Iterate(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode preTail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val ) {
                preTail.next = l1;
                l1 = l1.next;
            } else {
                preTail.next = l2;
                l2 = l2.next;
            }
                preTail = preTail;
        }
        preTail.next = l1==null ? l2 : l1;
        return null;
    }

    private ListNode _func1Recursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = _func1Recursive(l1.next,l2);
            return l1;
        } else {
            l2.next = _func1Recursive(l1,l2.next);
            return l2;
        }

    }
}
