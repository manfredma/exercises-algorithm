package manfred.exercises.leetcode.p0380;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class RandomizedSet {
    private Map<Integer, Integer> data = new HashMap<>();
    private List<Integer> idx = new ArrayList<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (data.containsKey(val)) {
            return false;
        }
        int size = idx.size();
        idx.add(val);
        data.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if (!data.containsKey(val)) {
            return false;
        }

        int id = data.remove(val);
        if (id != idx.size() - 1) {
            // 尝试与最后一个交换
            int swapValue = idx.get(idx.size() - 1);
            idx.set(id, swapValue);
            data.put(swapValue, id);
        }
        idx.remove(idx.size() - 1);
        return true;
    }

    public int getRandom() {
        int random = ThreadLocalRandom.current().nextInt(idx.size());
        return idx.get(random);
    }
}
