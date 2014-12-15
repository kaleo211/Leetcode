import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Interval> i = new ArrayList<Interval>();

        i.add(new Interval(2, 26));
        i.add(new Interval(7, 18));
        // i.add(new Interval(1, 3));
        // i.add(new Interval(6));

        List<Interval> r = s.merge(i);
        for (Interval in: r)
            System.out.println(in.start+" "+in.end);
    }

    public List<Interval> merge(List<Interval> intervals) {

        int len = intervals.size();
        List<Interval> r = new ArrayList<Interval>();
        if (len<1)
            return r;

        Collections.sort(intervals, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.start - o2.start;
                    }
                });

        int end = intervals.get(0).end;
        int start = intervals.get(0).start;
        for (int i=1; i<len; i+=1) {
            if (intervals.get(i).start>end) {
                r.add(new Interval(start, end));
                start=intervals.get(i).start;
                end = intervals.get(i).end;

            } else if (end<intervals.get(i).end) {
                end = intervals.get(i).end;
            }
        }
        r.add(new Interval(start, end));

        return r;
    }
}
