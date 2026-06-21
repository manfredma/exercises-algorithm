# 股票价格跨度

设计一个算法收集某些股票的每日报价，并返回该股票当日价格的**跨度**。

当日股票价格的跨度被定义为：股票价格**小于或等于**今天价格的最大连续日数（从今天开始往回数，包括今天）。

- 例如，未来 7 天股票价格为 `[100,80,60,70,60,75,85]`，跨度为 `[1,1,1,2,1,4,6]`。

实现 `StockSpanner` 类：

- `StockSpanner()` 初始化类对象
- `int next(int price)` 给出今天的股价 `price`，返回该股票当日价格的跨度

## 示例：

```
输入：
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
输出：
[null, 1, 1, 1, 2, 1, 4, 6]

解释：
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // 返回 1
stockSpanner.next(80);  // 返回 1
stockSpanner.next(60);  // 返回 1
stockSpanner.next(70);  // 返回 2
stockSpanner.next(60);  // 返回 1
stockSpanner.next(75);  // 返回 4
stockSpanner.next(85);  // 返回 6
```

## 提示：

- `1 <= price <= 10^5`
- 最多调用 `next` 方法 `10^4` 次
