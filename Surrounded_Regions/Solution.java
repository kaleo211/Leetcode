import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'},
                                                     {'X', 'O', 'O', 'X'},
                                                     {'X', 'X', 'O', 'X'},
                                                     {'X', 'O', 'X', 'X'}};

        new Solution().solve(board);
        for (int i=0; i<board.length; i+=1) {
            for (int j=0; j<board[0].length; j+=1) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public void solve(char[][] board) {
        int row = board.length;
        if (row<1) {
            return;
        }
        int col = board[0].length;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i<col; i+=1) {
            if (board[0][i]=='O')
                stack.push(i);
            if (board[row-1][i]=='O')
                stack.push((row-1)*col+i);
        }

        for (int i=1; i<row-1; i+=1) {
            if (board[i][0]=='O')
                stack.push(col*i);
            if (board[i][col-1]=='O')
                stack.push(col*i+col-1);
        }

        int i=0, j=0, n = 0;
        while (!stack.empty()) {
            n = stack.pop();
            i = n/col;
            j = n%col;
            board[i][j] = 'T';
            if (i+1<row && board[i+1][j]=='O')  stack.push(n+col);
            if (i-1>=0 && board[i-1][j]=='O') stack.push(n-col);
            if (j+1<col && board[i][j+1]=='O') stack.push(n+1);
            if (j-1>=0 && board[i][j-1]=='O') stack.push(n-1);
        }

        for (int h=0; h<row; h+=1) {
            for (int k=0; k<col; k+=1) {
                if (board[h][k]=='T') {
                    board[h][k] = 'O';
                } else {
                    board[h][k] = 'X';
                }
            }
        }
    }
}
