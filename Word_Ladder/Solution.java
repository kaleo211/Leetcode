import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));

        // Set<String> dict = new HashSet<String>(Arrays.asList("a","b","c"));
        System.out.println(new Solution().ladderLength("hit", "cog", dict));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {

        int len = beginWord.length();
        // wordDict.remove(beginWord);
        // wordDict.remove(endWord);
        List<String> dict = new ArrayList<String>(wordDict);
        List<String> caculated = new ArrayList<String>();
        List<String> tmp = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();

        tmp.add(beginWord);

        int step = 1;
        while (true) {
            System.out.println("step: "+step);
            for (String s: caculated) {System.out.print(s+", ");}System.out.println();

            boolean valid = true, first = true;
            for (String w: caculated) {
                valid = true;
                first = true;
                for (int i=0; i<len; i+=1) {
                    if (endWord.charAt(i)!=w.charAt(i)) {
                        if (first) {
                            first = false;
                        } else {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid) {
                    return step;
                }
            }

            if (tmp.size()==0) {
                break;
            }
            caculated.clear();
            caculated.addAll(tmp);
            tmp.clear();
            step+=1;
            for (String c: caculated) {
                for (String word: dict) {
                    if (visited.contains(word)) continue;
                    valid = true;
                    first = true;
                    for (int i=0; i<len; i+=1) {
                        if (c.charAt(i)!=word.charAt(i)) {
                            if (first) {
                                first = false;
                            } else {
                                valid = false;
                                break;
                            }
                        }
                    }
                    if (valid) {
                        tmp.add(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }
}
