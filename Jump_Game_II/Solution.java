/**
 * Greedy
 * Shocked!
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{2, 1};
        System.out.println(new Solution().jump(a));
    }

    public int jump(int[] A) {
        int len = A.length;
        int head = 0, tail = 0, steps = 0;

        for (int i=0; i<len; i+=1) {
            if (i>tail) {
                steps += 1;
                tail = head;
            }
            head = head>(i+A[i])?head:(i+A[i]);
        }
        return steps;
    }
}


// Time Limit Exceeded
// /**
//  * step[i] stands for the least steps from 0 to i;
//  *
//  */

// import java.util.Arrays;

// public class Solution {

//     public static void main(String[] args) {
//         int[] a = new int[]{2, 1};
//         System.out.println(new Solution().jump(a));
//     }

//     public int jump(int[] A) {
//         int len = A.length;
//         if (len<2) {
//             return 0;
//         }

//         int[] step = new int[len];
//         Arrays.fill(step, Integer.MAX_VALUE);
//         step[0] = 0;

//         boolean found = false;

//         for (int i=0; i<len-1&&!found; i+=1) {

//             for (int j=A[i]; j>=1&&!found; j-=1) {
//                 if (i+j>=len-1) {
//                     found = true;
//                     step[len-1] = step[i]+1;

//                 } else if (step[i+j]>step[i]+1) {
//                     step[i+j] = step[i]+1;
//                 }
//             }
//         }
//         return step[len-1];
//     }
// }
