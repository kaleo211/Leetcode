import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;


public class Solution {

    public static void main(String[] args) {
        List<List<String>> r = new Solution().partition("seeslaveidemonstrateyetartsnomedievalsees");

        for (List<String> list: r) {
            for (String s: list) {
                System.out.print(s+", ");
            }
            System.out.println();
        }
    }




    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        Queue<List<String>> queue = new LinkedList<List<String>>();

        int length = s.length();
        List<String> list = new ArrayList<String>(length);
        for (int i=0; i<length; i+=1) {
            list.add(String.valueOf(s.charAt(i)));
        }


        result.add(list);
        queue.add(list);

        while (!queue.isEmpty()) {
            List<String> tmp = queue.poll();
            int len = tmp.size();
            for (int i=0; i<len; i+=1) {
                if (i+1<len && tmp.get(i).equals(tmp.get(i+1))) {
                    List<String> newR = new ArrayList<String>(tmp);
                    newR.set(i, newR.get(i)+newR.get(i+1));
                    newR.remove(i+1);
                    if (!result.contains(newR)) {
                        result.add(newR);
                        queue.add(newR);
                    }
                }
                if (i+2<len && tmp.get(i).equals(tmp.get(i+2))) {
                    List<String> newR = new ArrayList<String>(tmp);
                    newR.set(i, newR.get(i)+newR.get(i+1)+newR.get(i+2));
                    newR.remove(i+2);
                    newR.remove(i+1);
                    if (!result.contains(newR)) {
                        result.add(newR);
                        queue.add(newR);
                    }
                }
            }
        }

        return result;
    }
}
