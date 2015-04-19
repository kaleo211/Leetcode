import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String[] e = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(new Solution().evalRPN(e));
    }

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len<1) return 0;
        int[] value = new int[len];
        int top = 0;

        for (int i=0; i<len; i+=1) {
            String r = tokens[i];

            if (r.length()>1 || r.charAt(0)>='0' && r.charAt(0)<='9') {
                System.out.println("r: "+r);
                value[top] = Integer.valueOf(r);
                top += 1;

            } else {
                int v2 = value[top-1];
                int v1 = value[top-2];
                int val = 0;
                if ("+".equals(r)) val = v1+v2;
                else if ("-".equals(r)) val = v1-v2;
                else if ("*".equals(r)) val = v1*v2;
                else if ("/".equals(r)) val = v1/v2;
                value[top-2] = val;
                System.out.println("v2: "+v2+" v1: "+v1);
                System.out.println("r: "+r+"val: "+val);
                top -= 1;
            }
        }

        return value[0];
    }
}
