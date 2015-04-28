import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {

    public static void main(String[] args) {
        UndirectedGraphNode g1 = new UndirectedGraphNode(-1);
        UndirectedGraphNode g2 = new UndirectedGraphNode(1);
        UndirectedGraphNode g3 = new UndirectedGraphNode(0);
        // g1.neighbors.add(g1);
        // g1.neighbors.add(g1);
        g1.neighbors.add(g2);g2.neighbors.add(g1);
        g1.neighbors.add(g3);g3.neighbors.add(g1);
        g2.neighbors.add(g3);g3.neighbors.add(g2);
        UndirectedGraphNode r = new Solution().cloneGraph(null);

        // if node had been visited, put it into this map
        Map<UndirectedGraphNode, Integer> map = new HashMap<UndirectedGraphNode, Integer>();
        // bfs, queue
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        if (r!=null) {
            queue.add(r);
            map.put(r, 0);
        }

        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();

            System.out.println("label: "+tmp.label+" level: "+map.get(tmp));
            System.out.println("neighbors: ");
            for (UndirectedGraphNode n: tmp.neighbors) {
                System.out.print(n.label+", ");
                if (!map.containsKey(n)) {
                    queue.add(n);
                    map.put(n, map.get(tmp)+1);
                }
            }
            System.out.println();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // if node had been visited, put it into this map
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();

        // bfs, queue
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        if (node!=null) {
            queue.add(node);
            set.add(node);
        }

        // construct all nodes first
        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            UndirectedGraphNode nn = new UndirectedGraphNode(tmp.label);
            map.put(tmp, nn);
            for (UndirectedGraphNode n: tmp.neighbors) {
                if (!set.contains(n)) {
                    queue.add(n);
                    set.add(n);
                }
            }
        }

        // establish the connections
        set = new HashSet<UndirectedGraphNode>();
        queue = new LinkedList<UndirectedGraphNode>();

        if (node!=null) {
            queue.add(node);
            set.add(node);
        }
        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            UndirectedGraphNode cur = map.get(tmp);
            for (UndirectedGraphNode n: tmp.neighbors) {
                cur.neighbors.add(map.get(n));
                if (!set.contains(n)) {
                    queue.add(n);
                    set.add(n);
                }
            }
        }

        return map.get(node);
    }
}
