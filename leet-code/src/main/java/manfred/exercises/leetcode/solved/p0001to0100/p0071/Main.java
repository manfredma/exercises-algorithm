/*
Given an absolute path for a file (Unix-style), simplify it.
Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory.
Furthermore, a double period .. moves the directory up a level.
For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /,
and there must be only a single slash / between two directory names.
The last directory name (if it exists) must not end with a trailing /.
Also, the canonical path must be the shortest string representing the absolute path.

Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0071;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/simplify-path/ */

/**
 * LeetCode 第 71 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1
        assertEquals("/home", solution.simplifyPath("/home/"));
        // 题面示例 2
        assertEquals("/", solution.simplifyPath("/../"));
        // 题面示例 3
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
        // 题面示例 4
        assertEquals("/c", solution.simplifyPath("/a/./b/../../c/"));
        // 题面示例 5
        assertEquals("/c", solution.simplifyPath("/a/../../b/../c//.//"));
        // 题面示例 6
        assertEquals("/a/b/c", solution.simplifyPath("/a//b////c/d//././/.."));
        System.out.println("passed");
    }
}
