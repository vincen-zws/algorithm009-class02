public class MergeTwoLists21 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        return _func1(l1,l2);
//        return _func2Recursive(l1,l2);
        return _func3Iterate(l1,l2);
    }

    private ListNode _func3Iterate(ListNode l1, ListNode l2) {
      ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
      ListNode preTail = dummyHead;
      while (l1 != null && l2 != null) {
          if(l1.val < l2.val) {
              preTail.next = l1;
              l1 = l1.next;
          } else {
              preTail.next = l2;
              l2 = l2.next;
          }
          preTail = preTail.next;
      }
      preTail.next = l1 == null ? l2 : l1;
     return dummyHead.next;
    }

    private ListNode _func2Recursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
           return l1;
        }

        if (l1.val < l2.val) {
            l1.next = _func2Recursive(l1.next,l2);
           return l1;
        } else {
            l2.next = _func2Recursive(l1,l2.next);
            return l2;
        }
    }

    private ListNode _func1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode focus;
        ListNode other;
        ListNode result;
        if ( l1.val < l2.val ) {
            focus = result = l1;
            other = l2;
        } else {
            focus = result = l2;
            other = l1;
        }

        while (other != null) {
            if (focus.next == null) {
               focus.next = other;
               break;
            } else if (other.val < focus.next.val) {
                ListNode node = other;
                other = other.next;

                node.next = focus.next;
                focus.next = node;

//                focus = focus.next;
//            } else {
//                focus = focus.next;
//            }
            }
                focus = focus.next;
        }
        return focus;
    }
}
