# 1268. 搜索推荐系统

给你一个产品数组 `products` 和一个字符串 `searchWord`。

设计一个推荐系统：在依次输入 `searchWord` 的每一个字母后，推荐 `products` 数组中前缀与 `searchWord` 相同的最多三个产品。若有超过三个匹配项，请按字典序返回前三个。

请你以列表的形式，返回在输入 `searchWord` 每个字母后相应的推荐产品列表。

## 示例 1

```text
输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
输出：[["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
解释：按字典序排序后为 ["mobile","moneypot","monitor","mouse","mousepad"]。
输入 m 和 mo 后推荐 ["mobile","moneypot","monitor"]；输入 mou、mous 和 mouse 后推荐 ["mouse","mousepad"]。
```

## 示例 2

```text
输入：products = ["havana"], searchWord = "havana"
输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
```

## 示例 3

```text
输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
```

## 示例 4

```text
输入：products = ["havana"], searchWord = "tatiana"
输出：[[],[],[],[],[],[],[]]
```

## 提示

- `1 <= products.length <= 1000`
- `1 <= products[i].length <= 3000`
- `1 <= searchWord.length <= 1000`
- `products[i]` 和 `searchWord` 仅由小写英文字母组成。
