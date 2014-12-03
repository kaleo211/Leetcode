import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        HashSet<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(s.wordBreak("catsanddog", dict));
    }

    int len;
    String s;
    List<String> list;
    boolean[] sub;
    Set<String> dict;

    public List<String> wordBreak(String s, Set<String> dict) {
        this.s = s;
        len = s.length();
        sub = new boolean[len+1];
        sub[0] = true;
        list = new ArrayList<String>();
        this.dict = dict;

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

        dfs("", len);

        return list;
    }

    public void dfs(String pre, int i) {
        if (i==0) {
            list.add(pre.trim());
            return;
        }
        if (sub[i]) {
            for (int j=i-1; j>=0; j--) {
                if (sub[j]) {
                    String w = s.substring(j, i);
                    if (dict.contains(w)) {
                        dfs(" "+w+pre, j);
                    }
                }
            }
        }
    }
}
