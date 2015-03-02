import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("aaa", "aaab"));
    }

    public String minWindow(String S, String T) {
        int len_s = S.length();
        if (len_s<1) {
            return "";
        }
        String[] ss = new String[len_s];
        String[] keys = new String[len_s];
        int[] indexs = new int[len_s];

        int len_t = T.length();
        if (len_t>len_s)
            return "";
        String[] tt = new String[len_t];
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (int i=0; i<len_t; i+=1) {
            tt[i] = T.substring(i, i+1);
            if (count.containsKey(tt[i])) {
                count.put(tt[i], count.get(tt[i])-1);
            } else {
                count.put(tt[i], 0);
            }
        }

        int c = 0;
        for (int i=0; i<len_s; i+=1) {
            ss[i] = S.substring(i, i+1);
            if (count.containsKey(ss[i])) {
                keys[c] = ss[i];
                indexs[c] = i;
                c += 1;
            }
        }
        if (c<1) return "";

        int s=0, start=0, end=0;
        int min = Integer.MAX_VALUE;
        boolean found = false;

        for (int i=0; i<c; i+=1) {
            count.put(keys[i], count.get(keys[i])+1);
            // System.out.println(" i: "+i+" key: "+keys[i]+" count: "+count.get(keys[i])+" index: "+indexs[i]);
            if (!found) {
                boolean valid = true;
                for (int j=0; j<len_t; j+=1) {
                    if (count.get(tt[j]) < 1) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    found = true;
                }
            }

            if (found) {
                while (true) {
                    int sc = count.get(keys[s]);
                    if (sc>1) {
                        count.put(keys[s], count.get(keys[s])-1);
                        s += 1;
                    } else {
                        if (indexs[i]-indexs[s]+1<min) {
                            min = indexs[i]-indexs[s]+1;
                            start = indexs[s];
                            end = indexs[i];
                        }
                        break;
                    }
                }
            }
        }

        if (found) {
            return S.substring(start, end+1);
        } else {
            return "";
        }
    }
}
