package manfred.exercises.leetcode.p1146;

import java.util.ArrayList;
import java.util.List;

class SnapshotArray {

    int snap = 0;

    private List<int[]>[] cur;

    public SnapshotArray(int length) {
        cur = new ArrayList[length];
        for (int i = 0; i < cur.length; i++) {
            cur[i] = new ArrayList<>();
        }
    }

    public void set(int index, int val) {
        if (this.cur[index].isEmpty()) {
            this.cur[index].add(new int[] {snap, val});
        } else {
            int len = this.cur[index].size();
            int[] lastSnap = this.cur[index].get(len - 1);
            if (lastSnap[0] == snap) {
                this.cur[index].set(len - 1, new int[] {snap, val});
            } else {
                this.cur[index].add(new int[] {snap, val});
            }
        }
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snapId) {
        List<int[]> snapshots = this.cur[index];
        int left = 0, right = snapshots.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midSnapId = snapshots.get(mid)[0];
            if (midSnapId == snapId) {
                return snapshots.get(mid)[1];
            } else if (midSnapId > snapId) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 如果没有找到，则最终 left 就是插入的位置，right 是最后一个 snapId <= 查询值 的记录下标
        if (right < 0) {
            return 0;
        }
        return snapshots.get(right)[1];
    }
}
