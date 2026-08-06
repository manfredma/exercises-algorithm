package manfred.exercises.leetcode.p2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            nums2Set.add(num);
        }

        Set<Integer> onlyNums1 = new HashSet<>(nums1Set);
        onlyNums1.removeAll(nums2Set);
        Set<Integer> onlyNums2 = new HashSet<>(nums2Set);
        onlyNums2.removeAll(nums1Set);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(onlyNums1));
        result.add(new ArrayList<>(onlyNums2));
        return result;
    }
}
