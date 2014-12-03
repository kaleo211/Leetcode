public class Solution {

    public static void main(String[] args) {
        System.out.println("steps: "+new Solution().climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n<3)
            return n;
        int f1=1, f2=2, f3=0;
        for (int i=2; i<n; i++) {
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
