package manfred.exercises.leetcode.p1117;

import java.util.ArrayList;
import java.util.List;

/*
现在有两种线程，氧 oxygen 和氢 hydrogen，目标是组织这两种线程来产生水分子。

存在一个屏障（barrier），使得每个线程必须等候直到一个完整水分子能够被产生出来。
氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。

这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。

如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。

示例 1：
输入：water = "HOH"
输出："HHO"
解释："HOH" 和 "OHH" 依然都是有效解。

示例 2：
输入：water = "OOHHHH"
输出："HHOHHO"
解释："HOHHHO"、"OHHHHO"、"HHOHOH"、"HOHHOH"、"OHHHOH"、
"HHOOHH"、"HOHOHH" 和 "OHHOHH" 也都是有效解。

提示：
3 * n == water.length
1 <= n <= 20
water[i] == 'O' or water[i] == 'H'
输入字符串 water 中的 H 总数将会是 2 * n。
输入字符串 water 中的 O 总数将会是 n。
*/
/** LeetCode 第 1117 题的测试入口。 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        assertWater("HOH", new H2O());
        assertWater("OOHHHH", new H2O());
        assertWater("HOH", new H2O2());
        assertWater("OOHHHH", new H2O2());
    }

    private static void assertWater(String water, WaterMoleculeBuilder h2o) throws InterruptedException {
        StringBuffer output = new StringBuffer();
        List<Thread> threads = new ArrayList<>();
        for (char atom : water.toCharArray()) {
            if (atom == 'H') {
                threads.add(new Thread(() -> run(() -> h2o.hydrogen(() -> output.append('H')))));
            } else {
                threads.add(new Thread(() -> run(() -> h2o.oxygen(() -> output.append('O')))));
            }
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join(1000);
            if (thread.isAlive()) {
                throw new AssertionError("线程未在预期时间内结束");
            }
        }
        assertWaterMolecules(output.toString());
        System.out.println("通过：" + output);
    }

    private static void assertWaterMolecules(String output) {
        if (output.length() == 0 || output.length() % 3 != 0) {
            throw new AssertionError("输出长度错误：" + output);
        }
        for (int i = 0; i < output.length(); i += 3) {
            String molecule = output.substring(i, i + 3);
            int hydrogenCount = 0;
            int oxygenCount = 0;
            for (char atom : molecule.toCharArray()) {
                if (atom == 'H') {
                    hydrogenCount++;
                } else if (atom == 'O') {
                    oxygenCount++;
                }
            }
            if (hydrogenCount != 2 || oxygenCount != 1) {
                throw new AssertionError("无效水分子：" + molecule);
            }
        }
    }

    private static void run(InterruptibleTask task) {
        try {
            task.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private interface InterruptibleTask {
        void run() throws InterruptedException;
    }
}
