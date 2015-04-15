public class Solution {

    char[][] grid = null;
    boolean[][] visited = null;
    int row = 0, col = 0;

    public static void main(String[] args) {
        // char[][] A = new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        char[][] A = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(new Solution().numIslands(A));
    }

    public int numIslands(char[][] g) {
        grid = g;
        row = grid.length;
        if (row<1)
            return 0;
        col = grid[0].length;

        visited = new boolean[row][col];

        int islands = 0;
        for (int i=0; i<row; i+=1) {
            for (int j=0; j<col; j+=1) {
                if (grid[i][j]=='1' && !visited[i][j]) {
                    islands += 1;
                    dfs(i, j);
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j) {
        if (grid[i][j]=='1' && !visited[i][j]) {
            visited[i][j] = true;
            if (i+1<row) dfs(i+1, j);
            if (j+1<col) dfs(i, j+1);
            if (i-1>=0) dfs(i-1, j);
            if (j-1>=0) dfs(i, j-1);
        }
    }
}
