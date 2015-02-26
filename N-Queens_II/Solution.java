/**
 * position[i] stands for (i, position[i]) is a queen;
 */
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(2));
    }

    private int total = 0;

    public int totalNQueens(int n) {

        int[] position = new int[n];
        Arrays.fill(position, -1);

        int[] used = new int[n];
        Arrays.fill(used, 0);

        total = 0;

        for (int i=0; i<n; i+=1) {
            position[0] = i;
            used[i] = 1;
            find(n, position, 1, used);
            position[0] = -1;
            used[i] = 0;
        }

        return total;
    }

    private void find(int n, int position[], int cur, int used[]) {
        // System.out.println("cur: "+cur);
        if (cur==n) {
            total += 1;
            return;
        }

        boolean valid = false;
        for (int i=0; i<n; i+=1) {
            if (used[i]==0) {
                valid = true;
                for (int j=0; j<cur; j+=1) {
                    if (position[j]==i || j-cur==position[j]-i || j-cur==i-position[j]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    used[i] = 1;
                    position[cur] = i;
                    find(n, position, cur+1, used);
                    position[cur] = -1;
                    used[i] = 0;
                }
            }
        }
    }
}
