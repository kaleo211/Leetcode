import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] num = new int[] {1, 1, -2};
        List<List<Integer>> r = new Solution().threeSum(num);

        for (List<Integer> list: r) {
            for (Integer i: list) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }


    public List<List<Integer>> threeSum(int[] num) {
        int len = num.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        // no possibility
        if (len<3) return list;

        // whether this number is duplicate
        boolean[] dup = new boolean[len];

        qsort(num, 0, len-1);

        // remove duplicate numbers, so that each number is distinct
        int last = 1;
        boolean added =false;
        for (int i=1; i<len; i+=1) {
            if (num[i]!=num[i-1]) {
                num[last] = num[i];
                last += 1;
            } else {
                // if contains more than 2 0s, add(0,0,0) directly
                if (num[i]==0 && !added && i+1<len && num[i+1]==0) {
                    List<Integer> s = new ArrayList<Integer>();
                    s.add(0);s.add(0);s.add(0);
                    list.add(s);
                    added = true;
                }
                dup[last-1] = true;
            }
        }
        len = last;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<len; i+=1) {
            map.put(num[i], i);
        }
        // no way to have (0, 0, x!=0)
        if (map.containsKey(0)) {
            dup[map.get(0)] =false;
        }

        for (int i=0; i<len-1; i+=1) {
            int j = i;
            if (!dup[i]) j+=1;
            for (; j<len; j+=1) {
                int sum = -num[i]-num[j];
                if (sum<0) break;
                if (sum>num[len-1]) {
                    continue;
                }
                if (map.containsKey(sum)) {
                    int k = map.get(sum);
                    if (k>j || dup[j]&&k==j) {
                        ArrayList<Integer> s = new ArrayList<Integer>();
                        s.add(num[i]);
                        s.add(num[j]);
                        s.add(num[k]);
                        list.add(s);
                    }
                }
            }
        }

        return list;
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
