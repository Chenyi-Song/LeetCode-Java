import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 */
public class No017 {

    public void run() {
        // Input
        String digits = "234";

        // Solution
        List<String> result = letterCombinations(digits);

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

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }

        Map<Character, List<String>> keyMap = new HashMap<>();
        keyMap.put('2', Arrays.asList("a", "b", "c"));
        keyMap.put('3', Arrays.asList("d", "e", "f"));
        keyMap.put('4', Arrays.asList("g", "h", "i"));
        keyMap.put('5', Arrays.asList("j", "k", "l"));
        keyMap.put('6', Arrays.asList("m", "n", "o"));
        keyMap.put('7', Arrays.asList("p", "q", "r", "s"));
        keyMap.put('8', Arrays.asList("t", "u", "v"));
        keyMap.put('9', Arrays.asList("w", "x", "y", "z"));

        for (String s : keyMap.get(digits.charAt(0))) {
            result.add(s);
        }

        for (int i = 1; i < digits.length(); i++) {
            char c = digits.charAt(i);

            List<String> tempList = new ArrayList<>();
            while (!result.isEmpty()) {
                String temp = result.remove(0);
                for (String key : keyMap.get(c)) {
                    tempList.add(temp + key);
                }
            }
            result.addAll(tempList);
        }

        return result;
    }

}
