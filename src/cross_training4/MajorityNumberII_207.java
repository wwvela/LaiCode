package cross_training4;

import java.util.*;

public class MajorityNumberII_207 {
    //Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

    //Assumptions: The given array is not null
    //Examples
    //A = {1, 2, 1, 2, 1}, return [1, 2]
    //A = {1, 2, 1, 2, 3, 3, 1}, return [1]
    //A = {1, 2, 2, 3, 1, 3}, return []

    public List<Integer> majority(int[] a) {
        int sizelimit = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                if (map.size() < sizelimit) {
                    map.put(a[i], 1);
                } else {
                    for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
                        Map.Entry<Integer, Integer> item = it.next();
                        item.setValue(item.getValue() - 1);
                        if (item.getValue() == 0) {
                            it.remove();
                        }
                    }
                }
            }
        }

        //最后要重新检查一遍map中元素是否确实数量>1/3 这个方法的好处在于节省了空间
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, Integer> item = it.next();
            item.setValue(0);
        }
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
//        map.entrySet().removeIf(item -> item.getValue() <= a.length / 3);
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, Integer> item = it.next();
            if (item.getValue() <= a.length / 3) {
                it.remove();
            }
        }
        return new ArrayList<>(map.keySet());
    }

}
