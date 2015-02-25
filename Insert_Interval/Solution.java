
import java.util.List;
import java.util.ArrayList;


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {

    // public static void main(String[] args) {
    //     Solution s = new Solution();
    //     Interval i1 = new Interval(1, 3);
    //     Interval i2 = new Interval(6, 9);
    //     Interval i = new Interval(2, 5);
    //     List<Interval> r = s.insert()

    // }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> inte = new ArrayList<Interval>();
        boolean added = false;

        for (Interval i: intervals) {
            if (i.end < newInterval.start) {
                inte.add(i);
            } else if (i.start > newInterval.end) {
                if (!added) {
                    inte.add(newInterval);
                    added = true;
                }
                inte.add(i);
            } else {
                int start = i.start < newInterval.start ? i.start : newInterval.start;
                int end = i.end > newInterval.end ? i.end : newInterval.end;
                newInterval = new Interval(start, end);
            }
        }

        if ( inte.size()==0 || !added) {
            inte.add(newInterval);
        }

        return inte;
    }
}
