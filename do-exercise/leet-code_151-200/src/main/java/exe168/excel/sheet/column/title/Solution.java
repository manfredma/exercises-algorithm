package exe168.excel.sheet.column.title;

/**
 * LeetCode 第 168 题「Excel 表列名称」：26 进制转换，注意无 0 需要先减一。
 */
class Solution {

    public String convertToTitle(int n) {
        // 先确定位数
        int nn = n;
        int x = 0;
        while (nn > Math.pow(26, x)) {
            nn -= Math.pow(26, x);
            x++;
        }
        String r = "";
        for (int i = 0; i < x; i++) {
            r = "" + (char) ('A' + nn % 26) + r;
            nn = nn / 26;
        }
        return r;
    }
}