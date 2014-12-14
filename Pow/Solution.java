public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().pow(1.1, 2));
    }


    public double pow(double x, int n) {
        if (n>0)
            return power(x, n);
        else
            return 1.0/power(x, -n);
    }

    private double power(double x, int n) {
        if (n==0)
            return 1;
        double r = power(x, n/2);
        if (n%2==0)
            return r*r;
        return r*r*x;
    }

}
