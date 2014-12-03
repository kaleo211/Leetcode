import java.util.Set;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        HashSet<String> dict = new HashSet<String>();
        dict.add("dog");
        dict.add("s");
        System.out.println("1234567".substring(0, 1));
        System.out.println(s.wordBreak("dogs", dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] sub = new boolean[len+1];
        sub[0] = true;

        for (int i=0; i<len; i++) {
            if (sub[i]==false)
                continue;

            for (String word: dict) {
                int position = i + word.length();
                if (position>len || sub[position])
                    continue;
                if (s.substring(i, position).equals(word))
                    sub[position] = true;
            }
        }
        return sub[len];
    }
}
