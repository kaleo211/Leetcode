public class Solution {

    private int[] candies;
    private int[] ratings;

    public static void main(String[] args) {
        int[] ratings = new int[] {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
        System.out.println(new Solution().candy(ratings));
    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        this.ratings = ratings;
        candies = new int[len];
        for (int i=0; i<len; i+=1) {
            candies[i] = 1;
        }

        merge(0, len-1);

        int sum=0;
        for (int i=0; i<len; i+=1) {
            sum += candies[i];
            // if (i<len-1 && (ratings[i]<ratings[i+1] && candies[i]>=candies[i+1] ||
            //         ratings[i]>ratings[i+1] && candies[i]<=candies[i+1] ||
            //         ratings[i]==ratings[i+1] && candies[i]!=candies[i+1]))
            //  if (i<len-1 && i>0 && ratings[i]<ratings[i-1] && ratings[i]<ratings[i+1] && candies[i]!=1)
                System.out.println("i: "+i +" ratings: "+ratings[i]+" candies: "+candies[i]+", ");
        }
        return sum;
    }

    private void increase(int low, int high) {
        for (int i=low; i<=high; i+=1) {
            if (ratings[i]<=ratings[i-1]) {
                break;
            }
            if (ratings[i]>ratings[i-1] && candies[i]<=candies[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
    }

    private void decrease(int low, int high) {
        for (int i=high; i>=low; i-=1) {
            if (ratings[i]<=ratings[i+1]) {
                break;
            }
            if (ratings[i]>ratings[i+1] && candies[i]<=candies[i+1])  {
                candies[i] = candies[i+1] + 1;
            }
        }
    }

    private void merge(int low, int high) {
        if (low>=high)
            return;

        int mid = (low+high)/2;
        merge(low, mid);
        merge(mid+1, high);

        decrease(low, mid);
        increase(mid+1, high);
    }
}
