package datastructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListFromArray(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode head, point;

        head = new ListNode(nums[0]);
        point = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            point.next = node;
            point = node;
        }

        return head;
    }

    public static void printList(ListNode head) {
        StringBuilder builder = new StringBuilder("[");
        while (head != null) {
            builder.append(head.val).append(",");
            head = head.next;
        }
        if (builder.toString().endsWith(",")) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}