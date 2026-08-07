package manfred.exercises.leetcode.wip.p0735;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<int[]> rightQueue = new ArrayDeque<>();
        Deque<int[]> leftQueue = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                rightQueue.push(new int[] {asteroids[i], i});
            }

        }

        //
        return null;
    }
}
