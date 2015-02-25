/**
 * (i1).(i2).(i3).(i4)
 *
 * could not start with 0
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("010010"));
    }

    public List<String> restoreIpAddresses(String s) {

        int len = s.length();

        List<String> r = new ArrayList<String>();

        for (int i1=1; i1<=3; i1+=1) {
            if ( len-i1>9 || len-i1<3 )
                continue;
            String s1 = s.substring(0, i1);
            if (Integer.parseInt(s1)>255 || (s1.length()>1 && s1.charAt(0)=='0'))
                continue;

            for (int i2=1; i2<=3; i2+=1) {
                if (len-i1-i2>6 || len-i1-i2<2)
                    continue;
                String s2 = s.substring(i1, i1+i2);
                if (Integer.parseInt(s2)>255 || (s2.length()>1 && s2.charAt(0)=='0'))
                    continue;

                for (int i3=1; i3<=3; i3+=1) {
                    if (len-i1-i2-i3>3 || len-i1-i2-i3<1)
                        continue;
                    String s3 = s.substring(i1+i2, i1+i2+i3);
                    String s4 = s.substring(i1+i2+i3, len);
                    if (Integer.parseInt(s3)>255 || Integer.parseInt(s4)>255 ||
                            (s3.length()>1 && s3.charAt(0)=='0') ||
                            (s4.length()>1 && s4.charAt(0)=='0'))
                        continue;
                    r.add(s.substring(0,i1)+"."+
                             s.substring(i1, i1+i2)+"."+
                             s.substring(i1+i2, i1+i2+i3)+"."+
                             s.substring(i1+i2+i3, len));
                }
            }
        }

        return r;
    }
}
