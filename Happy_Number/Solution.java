import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(100000));
    }

    public boolean isHappy(int n) {
        int[] s = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);

        char[] bits = null;
        int len = 0;
        while (n!=1) {
            bits = String.valueOf(n).toCharArray();
            len = bits.length;
            n = 0;
            for (int i=0; i<len; i+=1) {
                n += s[bits[i]-'0'];
            }
            if (set.contains(n) && n!=1) {
                break;
            }
            set.add(n);
        }

        if (n==1) {
            return true;
        }
        return false;
    }
}
