public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean stackoverflow = false;
        for (int i=len-1; i>=0; i-=1) {
            if (digits[i]==9) {
                digits[i] = 0;
                if (i==0)
                    stackoverflow = true;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (stackoverflow) {
            int[] new_digits = new int[len+1];
            new_digits[0] = 1;
            System.arraycopy(digits, 0, new_digits, 1, len);
            return new_digits;
        } else {
            return digits;
        }
    }
}
