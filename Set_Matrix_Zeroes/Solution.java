public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] list = {{0}, {1}};
        s.setZeroes(list);
        for (int i=0; i<2; i++) {
            for (int j=0; j<1; j++) {
                System.out.print(list[i][j]);
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col=0;
        if (row>0)
            col = matrix[0].length;

        int[] n = new int[row];
        int[] m = new int[col];
        for (int i=0; i<row; i++) {
            n[i] = 1;
        }
        for (int i=0; i<col; i++) {
            m[i] = 1;
        }

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j]==0) {
                    n[i] = 0;
                    m[j] = 0;
                }
            }
        }

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (n[i]==0 || m[j]==0)
                    matrix[i][j] = 0;
            }
        }
    }
}
