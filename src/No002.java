/**
 * 2. Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 */
public class No002 {

    public void run() {
        ListNode l1 = buildList(new int[] { 3, 4, 2 });
        ListNode l2 = buildList(new int[] { 4, 6, 5 });

        ListNode result = addTwoNumbers(l1, l2);
        while (true) {
            System.out.print(result.val);

            if (result.next == null) {
                System.out.println();
                break;
            } else {
                System.out.print(", ");
                result = result.next;
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;

        int flag = 0;
        while (true) {
            int val = l1.val + l2.val + flag;

            if (val >= 10) {
                flag = val / 10;
                val = val % 10;
            } else {
                flag = 0;
            }
            l1.val = val;

            if (l1.next == null && l2.next == null) {
                if (flag > 0) {
                    l1.next = new ListNode(flag);
                }
                break;
            } else if (l1.next == null) {
                l1.next = new ListNode(flag);
            } else if (l2.next == null) {
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return head;
    }

    public ListNode buildList(int[] num) {
        ListNode head, point;
        head = new ListNode(num[0]);
        point = head;

        for (int i = 1; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            point.next = node;
            point = node;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
