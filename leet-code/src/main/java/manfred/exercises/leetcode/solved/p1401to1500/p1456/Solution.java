package manfred.exercises.leetcode.solved.p1401to1500.p1456;


class Solution {
    public int maxVowels(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int result = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i >= k) {
                // 当 i=k-1 的时候，已经完整进入窗口。因此之后当元素进入之后，需要有退出元素
                if (isVowel(s.charAt(i - k)) ) {
                    cur--;
                }
            }
            if (isVowel(s.charAt(i))) {
                cur++;
            }

            result = Math.max(result, cur);
        }
        return result;
    }

    private boolean isVowel(char check) {
        return check == 'a' || check == 'e' || check == 'i' || check == 'o' || check == 'u';
    }
}
