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

| Type | Package Pattern | Example |
|------|----------------|---------|
| LeetCode solution | `manfred.exercises.leetcode.pXXXX` | `manfred.exercises.leetcode.p0001` |
| CTCI problem | `manfred.exercises.ctci.cXXXX` | `manfred.exercises.ctci.c0101` |
| Algorithm impl | `manfred.exercises.algorithm.*` | `manfred.exercises.algorithm.sort.quick` |
| Data structure | `manfred.exercises.datastructure.*` | `manfred.exercises.datastructure.tree.heap` |

> Problem number format: LeetCode zero-padded to 4 digits (`p0001`); CTCI first two digits = chapter, last two = problem number (`c0101`).

## Per-Problem Directory Convention

Each LeetCode problem lives in its package:
- `Solution.java` — primary solution
- `Solution2.java` / `SolutionV2.java` — alternative solutions (optional)
- `Main.java` — entry point with `main` method
- `TreeNode.java` / `ListNode.java` — helper data structures (as needed)

## Adding a New Problem

1. Create files under `leet-code/src/main/java/manfred/exercises/leetcode/p0055/`
2. No changes to `pom.xml` required (module already registered)
