# exercises-algorithm

Algorithm and data structure practice project, Java 8, flat Maven multi-module structure.

[中文](README.md)

## Project Structure

```
exercises-algorithm/
├── pom.xml              ← Parent POM, unified dependency management
├── leet-code/           ← LeetCode problems (560+, problems 1-1400)
├── ctci/                ← Cracking the Coding Interview, Chapter 1
├── common-algorithm/    ← Common algorithms (sorting, string matching, DP, graphs)
├── data-structure/      ← Data structures (heap, BST, red-black tree, graph)
└── data/                ← File I/O utility practice
```

- `groupId`: `manfred.end`, `artifactId`: `exercises-algorithm`, `version`: `1.0-SNAPSHOT`
- Java version: 8

## Quick Start

```bash
# Compile all modules
mvn clean compile -DskipTests -Dsort.skip=true

# Compile a single module
mvn clean compile -pl leet-code -Dsort.skip=true

# Run tests
mvn clean test -Dsort.skip=true
```

## Package Naming Convention

| Type              | Package Pattern                     | Example                                     |
|-------------------|-------------------------------------|---------------------------------------------|
| Completed LeetCode solution | `manfred.exercises.leetcode.solved.pXXXXtoYYYY.pZZZZ` | `manfred.exercises.leetcode.solved.p0301to0400.p0328` |
| Work-in-progress LeetCode solution | `manfred.exercises.leetcode.wip.pXXXX` | `manfred.exercises.leetcode.wip.p0735` |
| CTCI problem      | `manfred.exercises.ctci.cXXXX`      | `manfred.exercises.ctci.c0101`              |
| Algorithm impl    | `manfred.exercises.algorithm.*`     | `manfred.exercises.algorithm.sort.quick`    |
| Data structure    | `manfred.exercises.datastructure.*` | `manfred.exercises.datastructure.tree.heap` |

> Problem number format: LeetCode zero-padded to 4 digits (`p0001`); CTCI first two digits = chapter, last two = problem number (`c0101`).

## Per-Problem Directory Convention

LeetCode problems are organized by status and number range: completed problems live in `solved/pXXXXtoYYYY/pZZZZ/`, while work-in-progress problems live in `wip/pZZZZ/`. Each problem directory contains:
- `Solution.java` — primary solution
- `Solution2.java` / `SolutionV2.java` — alternative solutions (optional)
- `Main.java` — entry point with `main` method
- `TreeNode.java` / `ListNode.java` — helper data structures (as needed)

## Adding a New Problem

1. Create files under `leet-code/src/main/java/manfred/exercises/leetcode/wip/p0055/` with package `manfred.exercises.leetcode.wip.p0055`
2. After implementation and verification, move them to `solved/p0001to0100/p0055/` and update the package declarations and cross-problem imports
3. No changes to `pom.xml` required (module already registered)

> Keep all LeetCode test cases in each problem's `Main.main`, using assertion helpers. Do not maintain JUnit or TestNG test classes in `src/test/java`.
