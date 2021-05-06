import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if: 
 *  1.Open brackets must be closed by the same type of brackets. 
 *  2.Open brackets must be closed in the correct order.
 */
public class No020 {

    public void run() {
        // Input
        String s = "([]{)}";

        // Solution
        boolean result = isValid(s);

        // Output
        System.out.println(result);
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            // s.length() is odd, can not be valid
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<Character>();

        int i = 0;
        while (i < s.length()) {
            Character c = s.charAt(i);

            if (map.values().contains(c)) {
                // open brackets
                stack.push(c);
            } else {
                // close brackets
                if (stack.isEmpty()) {
                    return false;
                }

                Character top = stack.pop();
                if (!top.equals(map.get(c))) {
                    return false;
                }
            }

            i++;
        }

        return stack.isEmpty();
    }

}
