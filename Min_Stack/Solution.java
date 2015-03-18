import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(2);
        s.push(0);
        s.push(3);
        s.push(0);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
    }
}

class MinStack {

    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> min = new ArrayList<Integer>();

    public void push(int x) {
        stack.add(x);
        if (min.size()==0 || x<=min.get(min.size()-1)) {
            min.add(x);
        }
    }

    public void pop() {
        if (getMin()==top()) {
            min.remove(min.size()-1);
        }
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        for (int i=0; i<min.size(); i+=1) {
            System.out.print(min.get(i)+", ");
        }
        System.out.println();
        return min.get(min.size()-1);
    }
}
