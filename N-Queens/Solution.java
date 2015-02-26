/**
 * position[i] stands for (i, position[i]) is a queen;
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String[]> r = s.solveNQueens(8);
        for (String[] ss: r) {
            int len = ss.length;
            for (int i=0; i<len; i+=1) {
                System.out.println(ss[i]);
            }
            System.out.println();
        }
    }

    public List<String[]> solveNQueens(int n) {

        int[] position = new int[n];
        Arrays.fill(position, -1);

        int[] used = new int[n];
        Arrays.fill(used, 0);

        List<String[]> list = new ArrayList<String[]>();

        for (int i=0; i<n; i+=1) {
            position[0] = i;
            used[i] = 1;
            find(n, position, 1, used, list);
            position[0] = -1;
            used[i] = 0;
        }

        return list;
    }

    private void find(int n, int position[], int cur, int used[], List<String[]> list) {
        // System.out.println("cur: "+cur);
        if (cur==n) {
            char[][] map = new char[n][n];
            String[] strings = new String[n];
            for (int i=0; i<n; i+=1) {
                Arrays.fill(map[i], '.');
                map[i][position[i]] = 'Q';
                strings[i] = String.valueOf(map[i]);
            }
            list.add(strings);
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
                    find(n, position, cur+1, used, list);
                    position[cur] = -1;
                    used[i] = 0;
                }
            }
        }
    }
}
