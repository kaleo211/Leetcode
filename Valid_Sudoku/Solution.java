import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]   {{'.','8','7','6','5','4','3','2','1'},
                                                        {'2','7','.','.','.','.','.','.','.'},
                                                        {'3','.','.','.','.','.','.','.','.'},
                                                        {'4','.','.','.','.','.','.','.','.'},
                                                        {'5','.','.','.','.','.','.','.','.'},
                                                        {'6','.','.','.','.','.','.','.','.'},
                                                        {'7','.','.','.','.','.','.','.','.'},
                                                        {'8','.','.','.','.','.','.','.','.'},
                                                        {'9','.','.','.','.','.','.','.','.'}};

        System.out.println(s.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        int[] row = new int[9];
        int[] col = new int[9];
        int[] block = new int[9];

        for (int i=0; i<9; i+=1) {
            Arrays.fill(row, 0);
            Arrays.fill(col, 0);
            for (int j=0; j<9; j+=1) {
                if (board[i][j]!='.') {
                    if (row[board[i][j]-'1']!=0) {
                        return false;
                    }
                    row[board[i][j]-'1'] = 1;
                }
                if (board[j][i]!='.') {
                    if (col[board[j][i]-'1']!=0) {
                        return false;
                    }
                    col[board[j][i]-'1'] = 1;
                }
            }
        }

        for (int i=0; i<9; i+=3) {
            for (int j=0; j<9; j+=3) {
                Arrays.fill(block, 0);

                for (int ii=0; ii<3; ii+=1) {
                    for (int jj=0; jj<3; jj+=1) {
                        if (board[i+ii][j+jj]!='.') {
                            if (block[board[i+ii][j+jj]-'1']!=0) {
                                return false;
                            }
                            block[board[i+ii][j+jj]-'1'] = 1;
                        }
                    }
                }
            }
        }
        return true;
    }
}
