import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        String[] ss = new String[]{"aad","dab","cac"};
        List<Integer> l = new Solution().findSubstring("cacdabaaddaa", ss);
        for (Integer i: l) {
            System.out.println(i+",");
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        int size = words.length;
        if (size<1) return list;

        int len = words[0].length();
        Map<String, Integer> dict = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i+=1) {
            if (dict.containsKey(words[i])) {
                dict.put(words[i], dict.get(words[i])+1);
            } else {
                dict.put(words[i], 1);
            }
        }

        int start = 0;
        boolean copy = false;
        Map<String, Integer> map = new HashMap<String, Integer>(dict);
        for (int i=0; i<=s.length()-len;) {
            String word = s.substring(i, i+len);
            System.out.println("i: "+i+" word: "+word+" start: "+start);
            if (map.containsKey(word)) {

                int n = map.get(word);
                i += len;
                if (n<1) {
                    start = start+1;
                    i = start;
                    map = new HashMap<String, Integer>(dict);
                    copy = false;

                } else {
                    map.put(word, n-1);

                    copy = true;
                    if ((i-start)/len==size) {
                        list.add(start);

                        map = new HashMap<String, Integer>(dict);
                        copy = false;
                        start = start+1;
                        i = start;
                    }
                }

            } else {
                if (copy) {
                    map = new HashMap<String, Integer>(dict);
                    copy = false;
                }
                start = start+1;
                i = start;
            }
        }

        return list;
    }
}
