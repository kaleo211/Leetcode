public class Solution {

    public static void main(String[] args) {
        int[][] p = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(p));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        if (m==0)
            return 0;
        int n=obstacleGrid[0].length;
        if (n==0)
            return 0;

        int[][] map = new int[m][n];
        for (int i=0; i<m; i++) {
            if (obstacleGrid[i][0]==1) // after this, its unreachable
                break;
            map[i][0] = 1;
        }
        for (int i=0; i<n; i++) {
            if (obstacleGrid[0][i]==1)
                break;
            map[0][i] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j]==1) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = map[i-1][j]+map[i][j-1];
                }
            }
        }
        return map[m-1][n-1];
    }
}
