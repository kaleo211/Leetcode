import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{]}"));
    }

    public boolean isValid(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i<len; i+=1) {
            if (ss[i]=='(' || ss[i]=='{' || ss[i]=='[') {
                stack.push((int)ss[i]);
            } else if (stack.empty() ||
                          ss[i]==')' && stack.pop()!='(' ||
                          ss[i]=='}' && stack.pop()!='{' ||
                          ss[i]==']' && stack.pop()!='[') {
                return false;
            }
        }

        if (!stack.empty())
            return false;
        return true;
    }
}
