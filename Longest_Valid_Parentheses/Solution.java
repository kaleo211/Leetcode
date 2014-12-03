import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("()()))())"));
    }

    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len==0 || len==1)
            return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<Integer>(); // store the index of unpaired parentheses

        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (c=='(') {
                stack.push(i);
            } else {
                if (!stack.empty() && s.charAt(stack.peek())=='(') {
                    stack.pop();
                    if (stack.empty()) {
                        max = i+1;
                    } else {
                        int start = stack.peek();
                        max = max<(i-start) ? (i-start) : max;
                    }
                } else {
                    stack.push(i);
                }
            }
        }

        return max;
    }
}
