package manfred.exercises.leetcode.p0345;

class Solution2 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !isVowel(chars[l])) l++;
            while (l < r && !isVowel(chars[r])) r--;
            if (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                return true;
            default:
                return false;
        }
    }
}
