public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(2147483646, 2147483647));
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m==n) return m;

        int[] num = new int[32];
        int nm = n - m;

        int tmp = m;
        int first = 0;
        for (int i=31; i>0; i-=1) {
            num[i] = tmp%2;
            tmp = tmp/2;
            if (tmp==0) {
                first = i;
                break;
            }
        }

        System.out.println("first"+first);
        for (int i=0; i<32; i+=1) {
            System.out.print(num[i]);
        }
        System.out.println();

        long k = 1;
        tmp = m;
        for (int i=31; i>=first; i-=1) {
            System.out.println("k: "+k);
            if (k<=nm) {
                tmp -= num[i]*k;
                k *= 2;

            } else {
                k *= 2;
                int r = (int)(m % k);
                System.out.println("r: "+r+" k: "+k);
                if (r<k/2 || r+nm>=k) {
                    tmp -= num[i]*k/2;
                }
            }
        }

        return tmp;
    }
}
