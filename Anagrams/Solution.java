
public class Solution {
    public List<String> anagrams(String[] strs) {

    }

    public void nextPermutation(int[] num) {
        int length = num.length;
        int partition = -1;

        for (int i=length-2; i>=0; i--) {
            if (num[i]<num[i+1]) {
                partition = i;
                break;
            }
        }

        if (partition!=-1) {
            for (int i=length-1; i>partition; i--) {
                if (num[i]>num[partition]) {
                    int tmp = num[partition];
                    num[partition] = num[i];
                    num[i] = tmp;
                    break;
                }
            }
        }

        for (int i=partition+1,j=length-1; i<j; i++, j--) {
            int s = num[i];
            num[i] = num[j];
            num[j] = s;
        }
    }

}
