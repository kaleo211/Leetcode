public class Solution {

    public static void main(String[] args) {
        // int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = new int[][]{{1,2},{3,4}};
        new Solution().rotate(matrix);
        int n = matrix.length;
        for (int i=0; i<n; i+=1) {
            for (int j=0; j<n; j+=1) {
                System.out.print(matrix[i][j]+", ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int m = (n-1);
        int k = m/2;
        if (n%2==1) {
            k -= 1;
        }

        for (int i=0; i<=m/2; i+=1) {
            for (int j=0; j<=k; j+=1) {
                System.out.println(i+" "+j);
                swap(matrix, m, n, i, j);
            }
        }
    }

    private void swap(int[][] matrix, int m, int n, int i, int j) {
        int tmp = matrix[i][j];

        matrix[i][j] = matrix[m-j][i];

        matrix[m-j][i] = matrix[m-i][m-j];

        matrix[m-i][m-j] = matrix[j][m-i];

        matrix[j][m-i] = tmp;
    }
}
