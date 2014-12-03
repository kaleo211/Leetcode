import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; next = null; random=null;}
};

public class Solution {

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        r1.next = r2;
        r2.next = r3;
        r2.random = r1;
        r3.random = r2;
        r1.random = r3;

        RandomListNode r = new Solution().copyRandomList(r1);
        while (r!=null) {
            System.out.println("val: "+r.label+" random: "+(r.random!=null?r.random.label:"null"));
            r = r.next;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode new_head = new RandomListNode(head.label);
        map.put(head, new_head);
        RandomListNode pre = new_head, tmp = head.next;

        while(tmp!=null) {
            RandomListNode current = new RandomListNode(tmp.label);
            pre.next = current;
            map.put(tmp, current);
            tmp = tmp.next;
            pre = current;
        }

        tmp = head;
        RandomListNode current = new_head;
        while (tmp!=null) {
            if (tmp.random!=null)
                current.random = map.get(tmp.random);
            tmp = tmp.next;
            current = current.next;
        }

        return new_head;
    }
}
