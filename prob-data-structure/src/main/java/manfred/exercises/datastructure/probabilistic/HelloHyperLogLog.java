package manfred.exercises.datastructure.probabilistic;

import com.clearspring.analytics.stream.cardinality.HyperLogLog;
import com.clearspring.analytics.stream.cardinality.ICardinality;

/**
 * 演示 HyperLogLog 基数估算算法的基本用法。
 * 使用 stream-lib 库对包含重复元素的整数序列进行基数（唯一值数量）统计，
 * 展示该算法以极小内存代价近似计算海量数据集不重复元素数量的能力。
 */
public class HelloHyperLogLog {

    public static void main(String[] args) {
        ICardinality card = new HyperLogLog(10);
        for (int i : new int[] { 1, 2, 3, 2, 4, 3 }) {
            card.offer(i);
        }
        System.out.println(card.cardinality()); // 4
    }
}
