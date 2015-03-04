public class Solution {

    public static void main(String[] args) {
        int[] a = new int[] {2,3,-2,4};
        System.out.println(new Solution().maxProduct(a));
    }



    public int maxProduct(int[] A) {
        int len = A.length;

        int max = A[0], min = A[0], product = A[0];


        for (int i=1; i<len; i+=1) {
            int a = max * A[i], b = min * A[i];

            max = max(max(a, b), A[i]);
            min = min(min(a, b), A[i]);
            product = max(product, max);
        }

        return product;
    }

    private int max(int a, int b) {
        return a>b?a:b;
    }

    private int min(int a, int b) {
        return a>b?b:a;
    }
}
