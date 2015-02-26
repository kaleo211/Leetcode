/**
 * sum[i][j]: minimum length from grid[0][0] to grid[i][j]
 *
 * sum[i][j] = min (sum[i-1][j], sum[i][j-1]) + grid[i][j]
 */


public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(s.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        int row = grid.length;
        if (row<1) {
            return 0;
        }
        int col = grid[0].length;

        int[][] sum = new int[row][col];

        sum[0][0] = grid[0][0];
        for (int i=1; i<row; i+=1) {
            sum[i][0] = sum[i-1][0]+grid[i][0];
        }
        for (int i=1; i<col; i+=1) {
            sum[0][i] = sum[0][i-1]+grid[0][i];
        }

        for (int i=1; i<row; i+=1) {
            for (int j=1; j<col; j+=1) {
                sum[i][j] = (sum[i-1][j]>sum[i][j-1] ? sum[i][j-1] : sum[i-1][j]) + grid[i][j];
            }
        }

        return sum[row-1][col-1];
    }
}
