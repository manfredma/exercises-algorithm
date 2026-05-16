package exe1206.design.skiplist;

/**
 * 跳表节点定义，包含当前层的后继指针 next 和下层指针 down，用于实现多层链表结构。
 */
class Node {

    Node next;

    Node down;

    int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{value=" + value + '}';
    }
}