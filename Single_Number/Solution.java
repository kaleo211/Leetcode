public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = {1, 4, 5 , 3, 5, 4, 3};
        System.out.println(s.singleNumber(A));
    }
    public int singleNumber(int[] A) {
        int number = 0;
        int length = A.length;
        for (int i=0; i<length; i++) {
            number = number ^ A[i];
        }
        return number;
    }
}
