package exe189.rotate.array;

/**
 * LeetCode 第 189 题「轮转数组」（方案2）：三次翻转：全部反转，前 k 反转，后 n-k 反转。
 */
class Solution2 {

    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        if (k == 0) {
            return;
        }

        // 计算一下最大公约数
        int dist = nums.length;
        int step = k;
        while (dist % step != 0) {
            int remainder = dist % step;
            dist = step;
            step = remainder;
        }

        for (int i = 0; i < step; i++) {
            int index = (nums.length - k + i) % nums.length;
            int tmp = nums[index];
            int tmp2;
            for (int j = 0; j <= nums.length / step; j++) {
                tmp2 = nums[index];
                nums[index] = tmp;
                tmp = tmp2;
                index = (index + k) % nums.length;
            }
        }
    }
}