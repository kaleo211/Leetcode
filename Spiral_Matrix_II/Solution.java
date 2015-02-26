/**
 * simulation, to right -> to bot -> to left -> to top
 *               3
 *           2      0
 *               1
 */

public class Solution {

    public static void main(String[] args) {
        int n = 0;
        int[][] r = new Solution().generateMatrix(n);
        for (int i=0; i<n; i+=1) {
            for (int j=0; j<n; j+=1) {
                System.out.print(r[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {

        if (n==0) {
            return new int[][]{};
        }

        int[][] m = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        int i=0, j=0;

        m[0][0] = 1;
        visited[0][0] = true;

        int direction = 0;
        int number = 2;
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
                    visited[i][j] = true;
                    m[i][j] = number;
                    number += 1;
                    last = true;
                }

            } else if (direction==1) {
                if (i+1>n-1 || visited[i+1][j]) {
                    if (!last)
                        break;
                    direction = 2;
                    last = false;
                } else {
                    i += 1;
                    visited[i][j] = true;
                    m[i][j] = number;
                    number += 1;
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
                    visited[i][j] = true;
                    m[i][j] = number;
                    number += 1;
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
                    visited[i][j] = true;
                    m[i][j] = number;
                    number += 1;
                    last = true;
                }
            }
        }
        return m;
    }
}
