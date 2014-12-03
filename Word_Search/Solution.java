public class Solution {

    int row=0, col=0;
    char[][] board;
    boolean[][] visit;

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] b = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(s.exist(b, "ABCB"));
    }


    public boolean exist(char[][] board, String word) {
        this.board = board;
        row = board.length;
        if (row>0)
            col = board[0].length;
        visit = new boolean[row][col];
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                visit[i][j] = false;

        boolean find = false;
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++) {
                find = dfs(i, j, word);
                if (find) {
                    i = row;
                    break;
                }
            }
        return find;
    }

    public boolean dfs(int i, int j, String word) {
        int len = word.length();

        if (i<0 || i>=row || j<0 || j>=col || len==0 || visit[i][j] || word.charAt(0)!=board[i][j])
            return false;
        visit[i][j] = true;

        if (len==1 && board[i][j]==word.charAt(0)) {
            return true;
        }

        boolean result;
        result = dfs(i-1, j, word.substring(1, len)) ||
                     dfs(i+1, j, word.substring(1, len)) ||
                     dfs(i, j-1, word.substring(1, len)) ||
                     dfs(i, j+1, word.substring(1, len));
        visit[i][j] = false;
        return result;
    }
}
