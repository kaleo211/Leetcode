public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("n: "+s.numTrees(3));
    }

    public int numTrees(int n) {
        if (n==0 || n==1)
            return 1;
        int number = 0;
        for (int i=1; i<=n; i++) {
            number += numTrees(i-1)*numTrees(n-i);
        }
        return number;
    }
}
