import java.util.ArrayList;
import java.util.List;

import datastructure.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * 
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 */
public class No019 {
    public void run() {
        // Input
        int[] testArray = new int[] { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.buildListFromArray(testArray);

        // Solution
        ListNode result = removeNthFromEnd(head, 2);

        // Output
        ListNode.printList(result);
    }

    /**
     * Solution
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();

        ListNode point = head;
        while (point != null) {
            list.add(point);
            point = point.next;
        }

        int delPos = list.size() - n;
        if (delPos == 0) {
            head = head.next;
        } else {
            list.get(delPos - 1).next = list.get(delPos).next;
        }

        return head;
    }

}
