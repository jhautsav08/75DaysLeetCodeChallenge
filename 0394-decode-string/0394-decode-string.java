import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String current = "";
        int number = 0;

        for (char ch : s.toCharArray()) {

            // build number
            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');
            }

            // opening bracket
            else if (ch == '[') {

                numStack.push(number);
                strStack.push(current);

                number = 0;
                current = "";
            }

            // closing bracket
            else if (ch == ']') {

                int repeat = numStack.pop();
                String previous = strStack.pop();

                StringBuilder temp =
                        new StringBuilder(previous);

                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }

                current = temp.toString();
            }

            // normal character
            else {

                current += ch;
            }
        }

        return current;
    }
}