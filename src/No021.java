import datastructure.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a sorted list. The list should
 * be made by splicing together the nodes of the first two lists.
 */
public class No021 {

    public void run() {
        // Input
        ListNode l1 = ListNode.buildListFromArray(new int[] { 1, 3, 5 });
        ListNode l2 = ListNode.buildListFromArray(new int[] { 2, 4, 6 });

        // Solution
        ListNode result = mergeTwoLists(l1, l2);

        // Output
        ListNode.printList(result);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head, point;

        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        point = head;
        while (true) {
            if (l1 == null) {
                point.next = l2;
                break;
            }
            if (l2 == null) {
                point.next = l1;
                break;
            }

            if (l1.val < l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;

        }

        return head;
    }

}