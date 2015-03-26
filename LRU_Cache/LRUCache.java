import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {

    ArrayList<Integer> list = null;
    HashMap<Integer, Integer> map = null;
    int limit = 0;

    public LRUCache(int capacity) {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        limit = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
            list.add(0, key);
            return map.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));

        } else {
            if (list.size()==limit) {
                int k = list.get(list.size()-1);
                list.remove(list.size()-1);
                map.remove(k);
            }
        }

        list.add(0, key);
        map.put(key, value);
    }
}
