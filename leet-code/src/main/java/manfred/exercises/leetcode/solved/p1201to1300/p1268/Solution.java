package manfred.exercises.leetcode.solved.p1201to1300.p1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> r = new ArrayList<>();
        Arrays.sort(products);
        int left = 0, right = products.length;
        for (int i = 0; i < searchWord.length(); i++) {
            // 使用二分法定位第一个不匹配的元素
            String pre = searchWord.substring(0, i + 1);
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (products[mid].startsWith(pre) || products[mid].compareTo(pre) > 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 收集结果，并更新 right 到合适的位置
            List<String> curMatched = new ArrayList<>();
            for (int j = left; j < products.length; j++) {
                if (!products[j].startsWith(pre)) {
                    break;
                }
                if (curMatched.size() < 3) {
                    curMatched.add(products[j]);
                }
                // 保持 right 是第一个不匹配的下标
                right = j + 1;
            }
            r.add(curMatched);
        }
        return r;
    }
}
