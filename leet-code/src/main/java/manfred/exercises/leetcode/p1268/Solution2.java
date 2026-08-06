package manfred.exercises.leetcode.p1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> recommendations = new ArrayList<>();
        int left = 0;
        int right = products.length;
        for (int i = 0; i < searchWord.length(); i++) {
            char current = searchWord.charAt(i);
            while (left < right && !matchesAt(products[left], i, current)) {
                left++;
            }
            while (left < right && !matchesAt(products[right - 1], i, current)) {
                right--;
            }

            List<String> matches = new ArrayList<>(3);
            for (int j = left; j < right && j < left + 3; j++) {
                matches.add(products[j]);
            }
            recommendations.add(matches);
        }
        return recommendations;
    }

    private boolean matchesAt(String product, int index, char expected) {
        return product.length() > index && product.charAt(index) == expected;
    }
}
