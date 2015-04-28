import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // int[] num = new int[] {43,75,-90,47,-49,72,17,-31,-68,-22,-21,-30,65,88,-75,23,97,-61,53,87,-3,33,20,51,-79,43,80,-9,34,-89,-7,93,43,55,-94,29,-32,-49,25,72,-6,35,53,63,6,-62,-96,-83,-73,66,-11,96,-90,-27,78,-51,79,35,-63,85,-82,-15,100,-82,1,-4,-41,-21,11,12,12,72,-82,-22,37,47,-18,61,60,55,22,-6,26,-60,-42,-92,68,45,-1,-26,5,-56,-1,73,92,-55,-20,-43,-56,-15,7,52,35,-90,63,41,-55,-58,46,-84,-92,17,-66,-23,96,-19,-44,77,67,-47,-48,99,51,-25,19,0,-13,-88,-10,-67,14,7,89,-69,-83,86,-70,-66,-38,-50,66,0,-67,-91,-65,83,42,70,-6,52,-21,-86,-87,-44,8,49,-76,86,-3,87,-32,81,-58,37,-55,19,-26,66,-89,-70,-69,37,0,19,-65,38,7,3,1,-96,96,-65,-52,66,5,-3,-87,-16,-96,57,-74,91,46,-79,0,-69,55,49,-96,80,83,73,56,22,58,-44,-40,-45,95,99,-97,-22,-33,-92,-51,62,20,70,90};
        int[] num = new int[]{-43,61,-62,24,73,64,-23,94,-65,-27,24,-56,8,54,0,19,-100,-64,-53,6,-22,13,-18,55,-41,37,34,-43,0,-8,-95,76,73,21,-93,16,98,60,70,-32,30,-7,-27,-73,79,-26,41,32,41,-5,82,-14,50,-94,22,62,60,-48,51,12,-34,68,-40,-20,-20,46,46,-79,1,82,-98,41,-79,-43,-76,-25,-94,-16,-25,46,-95,-79,53,-1,-30,43,93,17,72,66,83,-89,-16,42,40,87,-46,40,22,85,-91,46,-77,19,-56,-28,8,47,-20,65,8,60,-49,-86,-74,56,30,79,97,-89,14,-90,66,-12,-57,46,-61,87,72,13,75,75,36,79,-16,84,-49,-86,76,68,-8,-65,-86,-11,55,-69,-59,34,63,59,-11,43,16,7,93,57,-55,2,38,64,3,22,-9,-22,-34,-84,90,-71,-88,64,-19,13,-8,-81,-95,-38,-9,-25,82,57,60,-26,66,21,8,65,-38,-68,-59,24,91};
        System.out.println(new Solution().threeSumClosest(num, -231));
    }


    public int threeSumClosest(int[] num, int target) {
        int len = num.length;

        qsort(num, 0, len-1);
        int closest = 0;

        boolean[] dul = new boolean[len];
        boolean[] tri = new boolean[len];
        int last = 1;
        for (int i=1; i<len; i+=1) {
            if (num[i]!=num[i-1]) {
                num[last] = num[i];
                last += 1;
            } else {
                dul[last-1] = true;
                if (i-2>=0 && num[i]==num[i-2]) {
                    tri[last-1] = true;
                }
            }
        }
        len = last;

        for (int i=0; i<len; i+=1) {
            System.out.print(num[i]+", ");
        }
        System.out.println();


        int min = Integer.MAX_VALUE;
        for (int i=0; i<len; i+=1) {
            if (num[i]>target && num[i]>0 && num[i]-target>min) break;
            int j=i;
            if (!dul[i]) j+=1;

            for (; j<len; j+=1) {
                int sum = num[i]+num[j];
                int sub = sum-target;
                if (sum>target && sum>0 && sum-target>min) break;
                int k=j;
                if (!(dul[j]&&i!=j || i==j&&tri[i])) k+=1;

                for (; k<len; k+=1) {

                    int tri_sum = sum + num[k];
                    int tri_sub = sub + num[k];
                    if (Math.abs(tri_sub)<min) {
                        min = Math.abs(tri_sub);
                        closest = tri_sum;
                    }
                }
            }
        }
        return closest;
    }

    // quick sort
    private void qsort(int[] num, int low, int high) {
        if (low>=high) return;

        int i=low+1, j=high;
        int pivot = low;
        while (i<=j) {
            while (pivot<j && num[pivot]<=num[j]) j-=1;
            swap(num, pivot, j);
            pivot = j;

            if (pivot>i) {
                while (pivot>i && num[pivot]>=num[i]) i+=1;
                swap(num, pivot, i);
                pivot = i;

            } else {
                break;
            }
        }
        qsort(num, low, pivot-1);
        qsort(num, pivot+1, high);
    }

    private void swap(int[] num, int i, int j) {
        if (i==j) return;
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
