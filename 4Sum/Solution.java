import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Quad {
    int n1, n2, n3, n4;

    Quad(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + n1;
        result = prime*result + n2;
        result = prime*result + n3;
        result = prime*result + n2;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Quad other = (Quad) obj;
        if (n1 != other.n1)
            return false;
        if (n2 != other.n2)
            return false;
        if (n3 != other.n3)
            return false;
        if (n4 != other.n4)
            return false;
        return true;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = new int[]{1,0,-1,0,-2,2};

        // for (int i=0; i<50; i++)
        //     System.out.println("i: "+s.getI(i)+" j: "+s.getJ(i));
        List<List<Integer>> r = s.fourSum(num, 0);
        for (List<Integer> rr: r) {
            for (Integer i: rr) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }


    private int max(int i, int j) {
        return i>j ? i : j;
    }

    private int min(int i, int j) {
        return i<j ? i : j;
    }

    public List<List<Integer>> fourSum(int[] num, int target) {

        int len = num.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<Quad> hash = new HashSet<Quad>();

        if (len>=4) {
            int i, j;
            int len2 = len*(len-1)/2;
            int[] two = new int[len2];

            for (i=0; i<len; i+=1) {
                for (j=0; j<i; j+=1) {
                    two[i*(i-1)/2+j] = num[i]+num[j];
                }
            }

            for (i=0; i<len2; i+=1) {
                for (j=0; j<i; j+=1) {

                    if (two[i]+two[j]==target) {
                        int ii=getI(i), ji=getI(j);
                        if (ii!=ji) {
                            int ij=getJ(i, ii), jj=getJ(j, ji);
                            if (ii!=jj && ij!=ji && ij!=jj) {

                                int[] r = new int[] {num[ii], num[jj], num[ij], num[ji]};
                                Arrays.sort(r);

                                Quad q = new Quad(r[0], r[1], r[2], r[3]);
                                if (!hash.contains(q)) {
                                    hash.add(q);
                                    result.add(new ArrayList<Integer>(Arrays.asList(r[0], r[1], r[2], r[3])));
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }


    private int getI(int n) {
        n += 1;
        int i=(int)Math.sqrt(2*n), sum=i*(i+1)/2;
        while (n>sum) {
            i += 1;
            sum += i;
        }
        return i;
    }

    private int getJ(int n, int i) {
        return n - (i*i-i)/2;
    }
}
