public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] list = {0,0,0,5};
        System.out.println("single: " + s.singleNumber(list));
    }

    public int singleNumber(int[] A) {
        int[] number = new int[32];
        for (int i=0; i<32; i++)
            number[i] = 0;
        int length = A.length;
        for (int i=0; i<length; i++) {
            for (int j=0; j<32; j++) {
                number[j] += A[i]>>j & 1;
            }
        }
        int single = 0;
        int bit = 1;
        for (int i=0; i<32; i++) {
            single += bit*(number[i]%3);
            bit *= 2;
        }
        return single;
    }
}
