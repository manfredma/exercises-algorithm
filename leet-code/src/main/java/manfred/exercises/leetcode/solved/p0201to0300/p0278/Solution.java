package manfred.exercises.leetcode.solved.p0201to0300.p0278;

/** LeetCode 在线环境提供的版本检测 API 的本地测试桩。 */
class VersionControl {
    private final int firstBadVersion;

    VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    protected boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}

class Solution extends VersionControl {
    Solution(int firstBadVersion) {
        super(firstBadVersion);
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
