public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("", 1));
    }


    public String convert(String s, int nRows) {
        int len = s.length();
        if (len<2 || nRows==1) {
            return s;
        }

        int block_size = 2*nRows - 2;

        String ss = "";
        int k = 0;
        for (int i=0; i< nRows; i+=1) {
            int idx = i;
            if (i==0 || i==nRows-1) {
                while (idx < len) {
                    ss += s.charAt(idx);
                    idx += block_size;
                }
            }
            else {
                while (idx < len) {
                    ss += s.charAt(idx);
                    if (idx-i+block_size-idx%block_size < len) {
                        ss += s.charAt(idx-i+block_size-idx%block_size);
                        idx += block_size;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return ss;
    }
}
