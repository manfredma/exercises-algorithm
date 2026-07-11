package manfred.exercises.leetcode.p0714;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        int preMin = prices[0], preMax = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 是否有必要进入下一波段：如果当前的值比之前的大值 - fee 还要小，则可以开始新一波段了
            if (prices[i] + fee < preMax) {
                // 上一段落袋为安: 可能上一级段不需要投资
                result += preMax > (preMin + fee) ? preMax - preMin - fee : 0;
                preMin = preMax = prices[i];
                continue;
            }
            // 尝试替换其中的大值或小值
            if (prices[i] > preMax) {
                preMax = prices[i];
            } else if (prices[i] < preMin) {
                preMin = prices[i];
            }
        }
        // 尝试收获最后一个波段
        result += preMax > (preMin + fee) ? preMax - preMin - fee : 0;
        return result;
    }
}
