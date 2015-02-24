/**
 *  find the (m+n)/2 th element in the merged AB if (m+n)%2=1
 *  of find the (m+n)/2 and (m+n)/2+1 elements if (m+n)%2=0
 *
 *  let k be the element to be found
 *         section1           section2
 * A: a[0]...a[m/2], a[m/2+1]...a[m-1]
 * B: b[0]...b[n/2], b[n/2+1]...b[n-1]
 *         section3           section4
 *
 *  if a[m/2]>b[n/2] and k>(m+n+1)/2 drop section3
 *                                  else               drop section2
 *  else                  and k>(m+n+1)/2 drop section1
 *                                  else               drop section4
 */

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A={}, B={1};
        // System.out.println(Arrays.copyOfRange(A, 0, 1)[0]);
        System.out.println(s.findMedianSortedArrays(A, B));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;

        if ((m+n)%2==0) {
            // return find(A, B, (m+n)/2+1);
            return (find(A, B, (m+n)/2) + find(A, B, (m+n)/2+1)) / 2.0;
        } else {
            return find(A, B, (m+n)/2+1);
        }
    }

    private double find(int A[], int B[], int k) {
        int m = A.length, n = B.length;
        // System.out.println("m: "+m+" n: "+n+" k: "+k);

        if (m==0) {
            return B[k-1];
        }
        if (n==0) {
            return A[k-1];
        }
        if (k==1) {
            return A[0]<B[0] ? A[0] : B[0];
        }

        int[] s2 = Arrays.copyOfRange(A, (m+1)/2, m);
        int[] s3 = Arrays.copyOfRange(B, 0, (n)/2);
        int[] s1 = Arrays.copyOfRange(A, 0, (m)/2);
        int[] s4 = Arrays.copyOfRange(B, (n+1)/2, n);

        if ( A[(m-1)/2] > B[(n-1)/2] ) {
            if ( k >= (m+n)/2+1 ) {
                return find(A, s4, k-(n+1)/2);
            } else {
                return find(s1, B, k);
            }

        } else {
            if ( k >= (m+n)/2+1 ) {
                return find(s2, B, k-(m+1)/2);
            } else {
                return find(A, s3, k);
            }
        }
    }
}
