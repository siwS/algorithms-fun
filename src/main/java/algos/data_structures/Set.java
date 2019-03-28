package algos.data_structures;

import java.util.HashMap;
import java.util.Iterator;

public class Set<T> implements Cloneable, Iterable {

    HashMap<T, Object> map;

    public Set(){
        map = new HashMap();
    }

    public boolean add(T element) {
        return map.put(element, true) == null;
    }

    public boolean isEmpty() {
        return map.keySet().size() == 0;
    }


    public boolean remove(T element) {
        if (map.containsKey(element)) {
            map.remove(element);
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }
}
