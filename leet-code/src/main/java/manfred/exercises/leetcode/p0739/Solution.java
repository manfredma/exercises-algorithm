package manfred.exercises.leetcode.p0739;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = i + 1; j < answer.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
}
