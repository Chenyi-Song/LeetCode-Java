import java.math.BigInteger;

public class No002 {

    public void run() {
        ListNode l1 = buildList(new BigInteger("342"));
        ListNode l2 = buildList(new BigInteger("465"));

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
        BigInteger num1 = readNum(l1);
        BigInteger num2 = readNum(l2);

        return buildList(num1.add(num2));
    }

    public BigInteger readNum(ListNode l) {
        BigInteger big10 = new BigInteger("10");

        BigInteger num = new BigInteger("0");
        BigInteger n = new BigInteger("1");
        while (true) {
            num = num.add(new BigInteger(String.valueOf(l.val)).multiply(n));
            n = n.multiply(big10);

            if (l.next != null) {
                l = l.next;
            } else {
                break;
            }
        }

        return num;
    }

    public ListNode buildList(BigInteger total) {
        if (total.equals(new BigInteger("0"))) {
            return new ListNode(0);
        }

        BigInteger big10 = new BigInteger("10");
        BigInteger big0 = new BigInteger("0");

        ListNode head, point;
        BigInteger[] temp = total.divideAndRemainder(big10);
        head = new ListNode(temp[1].intValue());
        total = temp[0];
        point = head;

        while (total.compareTo(big0)>0) {
            temp = total.divideAndRemainder(big10);
            ListNode node = new ListNode(temp[1].intValue());
            total = temp[0];
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
