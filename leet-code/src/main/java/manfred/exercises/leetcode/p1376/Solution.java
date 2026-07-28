package manfred.exercises.leetcode.p1376;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 通知到所有员工的时间取决于链路上花费时间最长的员工
        int longestMinutes = 0;
        int[] totalInformTime = new int[n];
        Arrays.fill(totalInformTime, -1);
        for (int i = 0; i < n; i++) {
            if (totalInformTime[i] >= 0) {
                // 说明这名员工已经被计算过了，不需要再计算
                continue;
            }
            // 开始计算这条路径
            List<Integer> pathToRoot = new ArrayList<>();
            int managerId = manager[i];
            while (managerId != -1) {
                pathToRoot.add(managerId);
                if (totalInformTime[managerId] >= 0) {
                    // 如果这条路径已经计算过了，不需要再重复计算
                    break;
                }
                managerId = manager[managerId];
            }

            // 更新这条路径上的所有人员的时间，总负责人获取到消息的时间为 0
            int time = 0;
            if (!pathToRoot.isEmpty()) {
                time = totalInformTime[pathToRoot.get(pathToRoot.size() - 1)];
            }
            for (int i1 = pathToRoot.size() - 1; i1 >= 0; i1--) {
                totalInformTime[pathToRoot.get(i1)] = time;
                time += informTime[pathToRoot.get(i1)];
            }
            totalInformTime[i] = time;
            longestMinutes = Math.max(time, longestMinutes);
        }
        return longestMinutes;
    }
}
