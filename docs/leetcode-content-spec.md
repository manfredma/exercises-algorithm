# LeetCode 题面抓取与规范（共享）

本文件定义 LeetCode 题面的抓取方式与 `readme.md` / `Main.java` 题面注释的统一规范。初始化新题（[`leetcode-init-workflow.md`](leetcode-init-workflow.md)）与重刷已解决题（[`leetcode-refresh-workflow.md`](leetcode-refresh-workflow.md)）均依赖本规范；仅刷新题面格式（不重刷解法）时也只读本文件。`AGENTS.md` 中的约束优先。

## 抓取题面

在项目根目录执行：

```bash
python3 scripts/fetch-leetcode-problem.py <题号>
```

脚本走 LeetCode 中文站 GraphQL，按题号查询，成功时输出一行 JSON，字段：

| 字段 | 含义 |
|------|------|
| `num` / `padded` | 题号 / 4位补零（如 `13` / `0013`） |
| `slug` | URL slug（如 `roman-to-integer`） |
| `titleCn` / `titleEn` | 中文标题 / 英文标题 |
| `difficulty` | 难度（`Easy` / `Medium` / `Hard`） |
| `contentCn` | 题面正文（HTML 已转纯文本，`<sub>` 已转 Unicode 下标） |
| `images` | 题面图片元数据（`url` / `alt` / `filename`） |
| `examples` | 尽力提取的示例 `input` / `output` |
| `returnType` / `methodName` / `params` | 方法签名（Java 风格） |

**完整性铁律**：只有取得完整 JSON 后才可创建或更新题面、骨架和测试。请求失败、超时、空数据或字段不完整时可重试；仍失败则停止，**不得使用记忆、摘要或第三方题面补全**。

## README 与题面注释规范

- 题面描述、全部示例、解释和提示必须完整保留，**不能概括或改写**。
- README 标题下与 `Main.java` 的类级 Javadoc 中均写入链接，两者使用本次抓取的**同一 `slug`**：
  - `readme.md`：`> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/{slug}/)`
  - `Main.java`：imports 之后、`public class Main` 之前的类级 Javadoc 内使用：

    ```java
    /**
     * LeetCode 第 XXXX 题的测试入口。
     *
     * @see <a href="https://leetcode.cn/problems/{slug}/">LeetCode 中文站</a>
     */
    public class Main {
    ```

    题目链接 Javadoc 必须紧贴其声明；不得将孤立的 `/** 题目链接：... */` 置于 imports 前后。
- README 正文中的 Markdown 特殊字符必须按字面量可见：运算符等优先使用行内代码，示例放入 `text` 代码块，不能让字符被 Markdown 语法吞掉或额外显示转义符。
- HTML 下标转换为 Unicode 下标（如 `Rᵢ`、`Cⱼ`）；不得简化为普通字符，也不得使用 IntelliJ Markdown 预览不会渲染的 `<sub>` 标签。脚本输出的 `contentCn` 已完成此转换。

## Main 断言规范

`Main.java` 的断言统一用 `exercise-assert` 模块的 `manfred.exercises.assertion.Assert`（`import static` 导入）。断言支持**带描述（desc）重载**与**调用位置行号兜底**，失败信息格式 `[desc] expected: X, actual: Y (at File:line)`，便于在多解法、多用例中定位失败点。

### 用法约定（新题与重刷题默认遵循）

- **优先用带 desc 的重载**，desc 须能标识「是哪个用例」：
  - 输入是字符串且简短：直接用输入串，如 `assertEquals(expected, sol.method("H2O"), "input=\"H2O\"")`。
  - 输入是数组/列表/长串：用简短标签，如 `"n=2, 4 logs"`、`"case 1"`，或截断后的输入。
  - 用 `TestEntry` 循环（如 p0224）：用 `t.toString()` 作 desc。
- **desc 不传也可工作**（无 desc 版本保留），但失败信息只有行号、无用例内容，定位较慢；新写代码应带 desc。
- **List 等无序结果**需排序后比较：可用现有手写 wrapper（如 `assertListEquals(e, a, desc)` 内部 sort），或调用前自行排序再 `assertEquals(e, a, desc)`。`Assert.deepEquals` 不排序。
- 保留旧解法测试块时，新旧解法的断言都应带 desc（desc 含输入即可，行号已能区分解法）。

### 示例

```java
import static manfred.exercises.assertion.Assert.*;

// 直接断言带 desc
assertEquals(7, sol.calculate("3+2*2"), "input=\"3+2*2\"");
assertTrue(sol.isMatch("aa", "a*"), "input=\"aa\",p=\"a*\"");

// TestEntry 循环带 desc
for (TestEntry t : cases) {
    assertEquals(t.result, sol.calculate(t.expression), t.toString());
}
```

> 断言类源码：`exercise-assert/src/main/java/manfred/exercises/assertion/Assert.java`。带 desc 重载列表：`assertEquals(Object/long/double, ..., String)`、`assertNull/assertNotNull/assertSame/assertInRange(..., String)`。`assertTrue/assertFalse(condition, message)` 失败时 `message` 为 null 会显示通用提示而非字面 `"null"`。

## 图片规范

- 以脚本输出的 `images` 为**唯一来源**。每张图片下载至当前题目目录的 `images/`，README 使用本地相对路径引用，**不得保留 LeetCode 外链**。
- 图片必须出现在 LeetCode 中文站原题对应的位置。例如图片位于示例标题和输入之间时，README 也必须在两者之间插入。图片**不得置于 `text` 代码块中**，也**不得统一追加到文末**。

## 验证核对清单

逐项确认：

- README 与 Main 的链接一致，且均使用本次抓取的 `slug`。
- 每张远程图片均已下载，并按原题位置以本地相对路径引用。
- 特殊字符和 Unicode 下标在 IntelliJ Markdown 预览中可见。
- `Main` 覆盖全部示例和适用的关键场景。

编译命令必须包含 `-Dsort.skip=true`：

```bash
mvn -f pom.xml clean compile -pl leet-code -DskipTests -Dsort.skip=true
```
