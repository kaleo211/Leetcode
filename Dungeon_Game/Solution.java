public class Solution {

    public static void main(String[] args) {
        // int[][] d = new int[][]{{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
        // int[][] d = new int[][]{{0}};
        int[][] d = new int[][]{{1, -3, 3},{0, -2, 0},{-3, -3, -3}};
        System.out.println(new Solution().calculateMinimumHP(d));
    }

    public int calculateMinimumHP(int[][] dun) {
        int row = dun.length;
        if (row==0) {
            return 0;
        }
        int col = dun[0].length;

        int[][] least = new int[row][col];
        least[row-1][col-1] = dun[row-1][col-1]>0?1:(1-dun[row-1][col-1]);

        for (int i=col-2; i>=0; i-=1) {
            if (dun[row-1][i]<least[row-1][i+1])
                least[row-1][i] = least[row-1][i+1]-dun[row-1][i];
            else
                least[row-1][i] = 1;
        }

        for (int i=row-2; i>=0; i-=1) {
            if (dun[i][col-1]<least[i+1][col-1])
                least[i][col-1] = least[i+1][col-1]-dun[i][col-1];
            else
                least[i][col-1] = 1;
        }

        for (int i=row-2; i>=0; i-=1) {
            for (int j=col-2; j>=0; j-=1) {
                int right = (dun[i][j]<least[i][j+1])?(least[i][j+1]-dun[i][j]):1;
                int down = (dun[i][j]<least[i+1][j])?(least[i+1][j]-dun[i][j]):1;
                least[i][j] = right>down?down:right;
            }
        }

        for (int i=0; i<row; i+=1) {
            for (int j=0; j<col; j+=1) {
                System.out.print(least[i][j]+" ");
            }
            System.out.println();
        }

        return least[0][0];
    }
}
