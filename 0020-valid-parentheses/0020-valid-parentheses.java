class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // if stack empty → invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // check matching
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}