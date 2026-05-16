package exe49.group.anagrams;

import java.util.*;

/**
 * LeetCode 第 49 题「字母异位词分组」：排序后的字符串作 key 进行哈希分组。
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> stringIndex = new HashMap<>();

        int index = 0;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (stringIndex.containsKey(sorted)) {
                result.get(stringIndex.get(sorted)).add(str);
            } else {
                stringIndex.put(sorted, index);
                result.add(new ArrayList<>());
                result.get(stringIndex.get(sorted)).add(str);
                index++;
            }
        }
        return result;
    }
}