package manfred.end.algorithm.dynamic.programming;

/**
 * 背包问题演示：对比暴力递归、记忆化递归、动态规划三种解法的性能差异。
 */
public class KnapsackDemo {

    private int loop = 1_000_000;

    public static void main(String[] args) {
        new KnapsackDemo().run();
    }

    public void run() {
        Knapsack knapsack = new Knapsack();
        long begin = System.currentTimeMillis();

        for (int i = 0; i < loop; i++) {
            knapsack = new Knapsack();
            knapsack.bruteForce(0, 0);
        }

        System.out.println("最大重量=" + knapsack.maxWeight + ", cost=" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            knapsack = new Knapsack();
            knapsack.bruteForceWithMem(0, 0);
        }
        System.out.println("最大重量=" + knapsack.maxWeight + ", cost=" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            knapsack = new Knapsack();
            knapsack.dynamicProgramming();
        }
        System.out.println("最大重量=" + knapsack.maxWeight + ", cost=" + (System.currentTimeMillis() - begin));
    }
}
