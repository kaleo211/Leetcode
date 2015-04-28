public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public int maxArea(int[] height) {

        int len = height.length;
        if (len<2) return 0;
        int left = 0, right = len-1;

        int max = 0;
        while (left<right) {
            int area = Math.min(height[left], height[right])*(right-left);
            if (area>max) max = area;
            if (height[left]>height[right]) right-=1;
            else left+=1;
        }

        return max;
    }
}
