import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/..///c/./..//"));
    }

    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        int len = folders.length;

        Stack<String> stack = new Stack<String>();

        for (int i=0; i<len; i+=1) {
            if ("..".equals(folders[i]) && !stack.empty()) {
                stack.pop();
            } else if (!".".equals(folders[i]) && !"".equals(folders[i]) && !"..".equals(folders[i])) {
                stack.push(folders[i]);
            }
        }

        if (stack.empty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            Stack<String> r = new Stack<String>();
            while (!stack.empty()) {
                r.push(stack.pop());
            }
            while(!r.empty()) {
                sb.append("/");
                sb.append(r.pop());
            }

            return sb.toString();
        }
    }
}
