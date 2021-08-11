/**
 * 415. Add Strings
 * 
 * Given two non-negative integers, num1 and num2 represented as string, return
 * the sum of num1 and num2 as a string.
 * 
 * You must solve the problem without using any built-in library for handling
 * large integers (such as BigInteger). You must also not convert the inputs to
 * integers directly.
 */
public class No415 {

    public void run() {
        // Input
        String num1 = "11", num2 = "99";

        // Solution
        String result = addStrings(num1, num2);

        // Output
        System.out.println(result);
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;

        boolean flag = false;

        char zero = '0';

        while (true) {
            if (i < 0 && j < 0) {
                break;
            }

            int temp1 = i < 0 ? 0 : (num1.charAt(i) - zero);
            int temp2 = j < 0 ? 0 : (num2.charAt(j) - zero);
            int sum = temp1 + temp2 + (flag ? 1 : 0);

            if (sum >= 10) {
                sb.insert(0, sum % 10L);
                flag = true;
            } else {
                sb.insert(0, sum);
                flag = false;
            }

            i--;
            j--;
        }

        if (flag) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}