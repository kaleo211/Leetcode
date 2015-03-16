public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("11.1.0.1", "11.1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length, len2 = v2.length;

        int i = 0;
        for (; i<len1&&i<len2; i+=1) {
            if (!v1[i].equals(v2[i])) {
                return compare(Integer.valueOf(v1[i]), Integer.valueOf(v2[i]));
            }
        }

        if (len1>len2) {
            for (; i<len1; i+=1) {
                if (Integer.valueOf(v1[i])>0) {
                    return 1;
                }
            }
        } else if (len2>len1) {
            for (; i<len2; i+=1) {
                if (Integer.valueOf(v2[i])>0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    private int compare(int a, int b) {
        if (a>b) {
            return 1;
        } else if (a<b) {
            return -1;
        } else {
            return 0;
        }
    }
}
