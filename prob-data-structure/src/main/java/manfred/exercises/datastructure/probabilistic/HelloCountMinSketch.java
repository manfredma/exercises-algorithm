package manfred.exercises.datastructure.probabilistic;

import com.clearspring.analytics.stream.frequency.CountMinSketch;
import com.clearspring.analytics.stream.frequency.IFrequency;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 演示 Count-Min Sketch 概率数据结构的基本用法。
 * 使用 stream-lib 库对海量随机字符串进行频次统计，并从中提取 Top-K 高频元素，
 * 展示该算法在牺牲少量精度的前提下实现低内存高效计数的核心特性。
 */
public class HelloCountMinSketch {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            animals.add(String.valueOf(new Random().nextLong()));
        }
        IFrequency freq = new CountMinSketch(10, 5, 0);
        Map<String, Long> top = Collections.emptyMap();
        for (String animal : animals) {
            freq.add(animal, 1);
            top = Stream.concat(top.keySet().stream(), Stream.of(animal)).distinct()
                    .map(a -> new AbstractMap.SimpleEntry<>(a, freq.estimateCount(a)))
                    .sorted(Comparator.comparing(AbstractMap.SimpleEntry<String, Long>::getValue).reversed())
                    .limit(3)
                    .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey,
                            AbstractMap.SimpleEntry::getValue));
        }

        System.out.println(top); // {rabbit=25, bird=45, spider=35}
    }
}