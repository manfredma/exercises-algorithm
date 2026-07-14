package manfred.exercises.leetcode.p0841;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomSize = rooms.size();
        List<Integer> originKey = rooms.get(0);
        boolean[] visitedRooms = new boolean[roomSize];
        visitedRooms[0] = true;
        int visitSize = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (Integer key : originKey) {
            queue.offer(key);
        }
        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            if (visitedRooms[room]) {
                continue;
            }
            visitedRooms[room] = true;
            visitSize++;
            List<Integer> keys = rooms.get(room);
            for (Integer key : keys) {
                if (!visitedRooms[key]) {
                    // 如果房间之前没有开启过，则过滤掉（实际上是否有必要过滤呢？）
                    queue.offer(key);
                }
            }
        }

        return visitSize == roomSize;
    }
}
