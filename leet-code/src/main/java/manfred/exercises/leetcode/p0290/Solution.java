package manfred.exercises.leetcode.p0290;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");

        if (split.length != pattern.length()) {
            return false;
        }
        Map<Character, String> pattern2String = new HashMap<>();
        Map<String, Character> string2pattern = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern2String.containsKey(pattern.charAt(i))) {
                if (!pattern2String.get(pattern.charAt(i)).equals(split[i])) {
                    return false;
                }
            } else {
                pattern2String.put(pattern.charAt(i), split[i]);
            }
            if (string2pattern.containsKey(split[i])) {
                if (string2pattern.get(split[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            } else {
                string2pattern.put(split[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
