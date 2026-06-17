package manfred.exercises.leetcode.p0274;

class Solution {
    public int hIndex(int[] citations) {
        int[] countsPerCitation = new int[1001];
        for (int citation : citations) {
            countsPerCitation[citation]++;
        }

        int result = 0;
        int totalCount = 0;
        for (int i = Math.min(citations.length, 1000); i > 0; i--) {
            totalCount += countsPerCitation[i];
            if (totalCount >= i) {
                result = i;
                break;
            }
        }
        return result;
    }
}
