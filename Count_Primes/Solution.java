import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {

        if (n<3) return 0;

        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        int count = 0;
        for (int m=2; m<n; m+=1) {
            if (prime[m]) {
                for (int i=2; i*m<n; i+=1) {
                    prime[i*m] = false;
                }
                count += 1;
            }
        }
        return count;
    }
}
