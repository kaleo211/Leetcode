public class Solution {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'0', '1'}, {'1', '0'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height==0)
            return 0;
        int wide = matrix[0].length;
        int left=wide, right=0, top=height, bot=0;

        boolean c = true;
        for (int i=0; i<height&&c; i++)
            for (int j=0; j<wide; j++) {
                if (matrix[i][j]=='1') {
                    if (j<left)
                        left = j;
                    if (j>right)
                        right = j;
                    top = i;
                    c = false;
                }
            }

        c = true;
        for (int i=height-1; i>=0&&c; i--)
            for (int j=0; j<wide; j++) {
                if (matrix[i][j]=='1') {
                    if (j<left)
                        left = j;
                    if (j>right)
                        right = j;
                    bot = i;
                    c = false;
                }
            }
        System.out.println("bot: "+bot+" top: "+top+" left: "+left+" right: "+right);
        if (left==wide)
            return 0;
        else
            return (bot-top+1)*(right-left+1);
    }
}
