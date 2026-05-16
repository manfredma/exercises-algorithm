package manfred.exercises.leetcode.p811;

/**
 * LeetCode 第 811 题（子域名访问计数）的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 *Output:
 * ["901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com",
 *"951 com"]
        */
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(solution.subdomainVisits(cpdomains));
    }
}
