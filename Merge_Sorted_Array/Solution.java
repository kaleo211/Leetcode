public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int[] C = new int[m];
        for (int i=0; i<m; i+=1) {
            C[i] = A[i];
        }

        int i=0, j=0, k=0;
        while (i<m && j<n) {
            if (C[i]<B[j]) {
                A[k] = C[i];
                i += 1;
            } else {
                A[k] = B[j];
                j += 1;
            }
            k += 1;
        }
        while (i<m) {
            A[k] = C[i];
            k += 1;
            i += 1;
        }

        while (j<n) {
            A[k] = B[j];
            k += 1;
            j += 1;
        }
    }
}
