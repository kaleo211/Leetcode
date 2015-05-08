import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // int[][] c = new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        int[][] c = new int[][]{{0,1}};
        System.out.println(new Solution().canFinish(8, c));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i=0; i<numCourses; i+=1) {
            edges.add(new ArrayList<Integer>());
        }

        int[] level = new int[numCourses];
        int removed = 0;

        int len = prerequisites.length;
        for (int i=0; i<len; i+=1) {
            level[prerequisites[i][1]] += 1;
            edges.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<numCourses; i+=1) {
            if (level[i]==0) {
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            int cur = stack.pop();
            removed += 1;

            List<Integer> neighbors = edges.get(cur);
            for (Integer i: neighbors) {
                level[i] -= 1;
                if (level[i]==0) {
                    stack.push(i);
                }
            }
        }
        if (removed<numCourses)
            return false;
        return true;
    }
}
