/**
 * use binary search twice
 */

public class Solution {

    public static void main(String[] args) {
        // int[][] matrix = new int[][]{{1, 3, 5, 7}, {10,11,16,20}, {23, 30, 34, 50}};
        int[][] matrix = new int[][]{{1}};
        System.out.println(new Solution().searchMatrix(matrix, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = row(matrix, target, 0, matrix.length-1);
        if (r==-1) {
            return false;
        }
        return col(matrix[r], target, 0, matrix[r].length-1);
    }

    private int row(int[][] matrix, int target, int low, int high) {
        if (low>high) {
            return -1;
        }
        int mid = (low+high)/2;
        if (target >= matrix[mid][0] && (mid==matrix.length-1 || target<matrix[mid+1][0])) {
            return mid;
        } else if (target < matrix[mid][0]) {
            return row(matrix, target, low, mid-1);
        }
        return row(matrix, target, mid+1, high);
    }

    private boolean col(int[] matrix, int target, int low, int high) {
        if (low>high) {
            return false;
        }
        int mid = (low+high)/2;
        if (target == matrix[mid]) {
            return true;
        } else if (target < matrix[mid]) {
            return col(matrix, target, low, mid-1);
        }
        return col(matrix, target, mid+1, high);
    }
}
