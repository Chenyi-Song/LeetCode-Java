import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 */
public class No022 {

    public void run() {
        // Input
        int n = 4;

        // Solution
        List<String> result = generateParenthesis(n);

        // Output
        StringBuilder builder = new StringBuilder("[");
        for (String s : result) {
            builder.append(s).append(",");
        }
        if (builder.toString().endsWith(",")) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        generate(0, new char[2 * n], n, 0, 0, list);

        return list;
    }

    /**
     * @param index  current index
     * @param n      n pairs of parentheses
     * @param open   the count of open brackets
     * @param close  the count of close brackets
     * @param result result list
     */
    public void generate(int index, char[] temp, int n, int open, int close, List<String> result) {
        if (index == 0) {
            // The first one must be '('
            temp[0] = '(';
            generate(1, temp, n, 1, close, result);
        } else if (index == temp.length - 1) {
            // The last one must be ')'
            temp[index] = ')';
            result.add(new String(temp));
        } else {
            if (open == n) {
                // if the count of open brackets equals n, the rest part must be all ')'
                temp[index] = ')';
                generate(index + 1, temp, n, open, close + 1, result);
            } else if (open <= close) {
                /*
                 * if 1.the count of open brackets less than n 
                 *    2.the count of open brackets no more than close brackets 
                 * the next one must be '('
                 */
                temp[index] = '(';
                generate(index + 1, temp, n, open + 1, close, result);
            } else {
                temp[index] = '(';
                generate(index + 1, temp, n, open + 1, close, result);
                temp[index] = ')';
                generate(index + 1, temp, n, open, close + 1, result);
            }
        }
    }

}
