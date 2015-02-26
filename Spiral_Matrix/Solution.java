/**
 * simulation, to right -> to bot -> to left -> to top
 *               3
 *           2      0
 *               1
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[][] m = new int[][]{{1}};
        List<Integer> r = new Solution().spiralOrder(m);
        for (Integer i: r) {
            System.out.print(i+", ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        int m = matrix.length;
        if (m<1) return list;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        int i=0, j=0;

        list.add(matrix[0][0]);
        visited[0][0] = true;

        int direction = 0;
        boolean last = true;

        while (true) {
            if (direction==0) {
                if (j+1>n-1 || visited[i][j+1]) {
                    if (!last)
                        break;
                    direction = 1;
                    last = false;
                } else {
                    j += 1;
                    list.add(matrix[i][j]);
                    visited[i][j] = true;
                    last = true;
                }

            } else if (direction==1) {
                if (i+1>m-1 || visited[i+1][j]) {
                    if (!last)
                        break;
                    direction = 2;
                    last = false;
                } else {
                    i += 1;
                    list.add(matrix[i][j]);
                    visited[i][j] = true;
                    last = true;
                }

            } else if (direction==2) {
                if (j-1<0 || visited[i][j-1]) {
                    if (!last)
                        break;
                    direction = 3;
                    last = false;
                } else {
                    j -= 1;
                    list.add(matrix[i][j]);
                    visited[i][j] = true;
                    last = true;
                }

            } else {
                if (i-1<0 || visited[i-1][j]) {
                    if (!last)
                        break;
                    direction = 0;
                    last = false;
                } else {
                    i -= 1;
                    list.add(matrix[i][j]);
                    visited[i][j] = true;
                    last = true;
                }
            }
        }
        return list;
    }
}
