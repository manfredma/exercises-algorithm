#!/usr/bin/env python3
"""按题号计算 LeetCode 题目的归档段信息（段目录名、目录路径、package 声明）。

归档约定见 AGENTS.md：已完成题目归入 solved/pXXXXtoYYYY/pZZZZ/，其中
pXXXXtoYYYY 是题号所在的连续百题段（如 328 → p0301to0400，3105 → p3101to3200）。
package 为 manfred.exercises.leetcode.solved.pXXXXtoYYYY.pZZZZ。

本脚本把"题号 → 段目录/package"的换算从口算改为脚本输出，避免归档错段。

用法：
  python3 scripts/leetcode-segment.py <题号>           # 输出段目录/package，并校验 wip 是否就绪
  python3 scripts/leetcode-segment.py 3105
  python3 scripts/leetcode-segment.py 3105 --wip       # 同时校验 wip 路径
  python3 scripts/leetcode-segment.py 3105 --mv        # 打印从 wip 归档到 solved 的命令（不执行）
"""
import sys
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
LEET = ROOT / "leet-code/src/main/java/manfred/exercises/leetcode"
WIP = LEET / "wip"
SOLVED = LEET / "solved"


def pad4(n: int) -> str:
    return f"{n:04d}"


def segment_of(num: int) -> tuple[int, int]:
    """题号 → 所在百题段的 [起, 止]（含起不含止的命名用起+1..止）。"""
    start = (num - 1) // 100 * 100 + 1          # 段起点，如 3105 → 3101
    end = start + 99                             # 段终点，如 3101 → 3200
    return start, end


def segment_dir_name(num: int) -> str:
    s, e = segment_of(num)
    return f"p{pad4(s)}to{pad4(e)}"


def problem_dir_name(num: int) -> str:
    return f"p{pad4(num)}"


def solved_pkg(num: int) -> str:
    return f"manfred.exercises.leetcode.solved.{segment_dir_name(num)}.{problem_dir_name(num)}"


def wip_pkg(num: int) -> str:
    return f"manfred.exercises.leetcode.wip.{problem_dir_name(num)}"


def main():
    if len(sys.argv) < 2:
        print(__doc__, file=sys.stderr)
        sys.exit(2)
    try:
        num = int(sys.argv[1])
    except ValueError:
        print(f"错误：题号必须是整数，收到 {sys.argv[1]!r}", file=sys.stderr)
        sys.exit(2)
    if num <= 0:
        print(f"错误：题号必须为正整数，收到 {num}", file=sys.stderr)
        sys.exit(2)

    flags = set(sys.argv[2:])
    check_wip = "--wip" in flags or bool((WIP / problem_dir_name(num)).exists())
    print_mv = "--mv" in flags

    seg = segment_dir_name(num)
    prob = problem_dir_name(num)
    s, e = segment_of(num)

    print(f"题号          : {num}")
    print(f"所在百题段    : {s}–{e}")
    print(f"段目录名      : {seg}")
    print(f"题目目录名    : {prob}")
    print(f"solved 路径   : solved/{seg}/{prob}/")
    print(f"package(solved): {solved_pkg(num)}")
    print(f"package(wip)  : {wip_pkg(num)}")

    # 校验 solved 段目录与题目目录现状
    seg_dir = SOLVED / seg
    prob_dir = seg_dir / prob
    print()
    print(f"[校验] solved 段目录 {seg} 是否存在      : {'是' if seg_dir.exists() else '否（归档时需新建）'}")
    if seg_dir.exists():
        print(f"[校验] 该段已有题目            : {sorted(d.name for d in seg_dir.iterdir() if d.is_dir()) or '（空段）'}")
    print(f"[校验] 目标题目目录是否已存在  : {'是（⚠️ 冲突，勿覆盖）' if prob_dir.exists() else '否'}")

    if check_wip:
        wip_dir = WIP / prob
        print()
        print(f"[校验] wip 题目目录是否存在    : {'是' if wip_dir.exists() else '否（归档前应在 wip）'}")
        if wip_dir.exists():
            files = sorted(p.name for p in wip_dir.iterdir())
            print(f"[校验] wip 现有文件            : {files}")

    if print_mv:
        wip_dir = WIP / prob
        print()
        print("# 归档命令（从 wip 移到 solved 段）：")
        print(f"mkdir -p solved/{seg}")
        print(f"git mv wip/{prob} solved/{seg}/{prob}")
        print("# 更新 package（wip → solved）：")
        print(f"sed -i '' -E 's/package manfred\\.exercises\\.leetcode\\.wip\\.{prob};/package manfred.exercises.leetcode.solved.{seg}.{prob};/' solved/{seg}/{prob}/*.java")

    # 额外防错：若 wip 仍有该题目录但 solved 段写错，提示
    if (WIP / prob).exists() and (SOLVED / prob).exists():
        print(f"\n⚠️ wip 与 solved 同时存在 {prob}，请确认归档是否完成", file=sys.stderr)


if __name__ == "__main__":
    main()
