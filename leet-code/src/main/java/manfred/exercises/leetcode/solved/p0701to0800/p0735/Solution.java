package manfred.exercises.leetcode.solved.p0701to0800.p0735;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> rightDeque = new ArrayDeque<>();
        Deque<Integer> leftDeque = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                rightDeque.addFirst(asteroid);
            } else {
                // 尝试去对撞向右飞行的行星
                leftDeque.addFirst(asteroid);
                while (!rightDeque.isEmpty()) {
                    // 后进入的需要先碰撞
                    if (-asteroid > rightDeque.peekFirst()) {
                        rightDeque.pollFirst();
                    } else if (-asteroid == rightDeque.peek()) {
                        rightDeque.pollFirst();
                        leftDeque.pollFirst();
                        break;
                    } else {
                        // 仅销毁自己
                        leftDeque.pollFirst();
                        break;
                    }
                }
            }
        }

        // 向左飞行的放到前面，向右飞行的放到后面，否则肯定会相撞
        int[] r = new int[leftDeque.size() + rightDeque.size()];
        int i = 0;
        while (!leftDeque.isEmpty()) {
            r[i++] = leftDeque.pollLast();
        }
        while (!rightDeque.isEmpty()) {
            r[i++] = rightDeque.pollLast();
        }
        return r;
    }
}
