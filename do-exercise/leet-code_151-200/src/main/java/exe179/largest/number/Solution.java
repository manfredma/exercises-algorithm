package exe179.largest.number;

import java.util.Arrays;
        import java.util.Comparator;

/**
 * LeetCode 第 179 题「最大数」：自定义比较器，将数字拼接后按字典序排序。
 */
class Solution {
    public String largestNumber(int[] nums) {
        // String[] strNums = IntStream.of(nums).boxed().map(String::valueOf).toArray(String[]::new);
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new XComparator());
        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static class XComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }
}