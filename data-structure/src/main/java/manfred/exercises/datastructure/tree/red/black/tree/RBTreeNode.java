package manfred.exercises.datastructure.tree.red.black.tree;

/**
 * 红黑树节点：存储键值、颜色（红/黑）及父节点、左右子节点引用，使用哨兵 NIL_NODE 代替 null 简化边界处理。
 */
public class RBTreeNode<T> {

    public static final int RED = 1;
    public static final int BLACK = 0;

    public static RBTreeNode<?> NIL_NODE = new RBTreeNode<>();

    static {
        NIL_NODE.setColor(BLACK);
    }

    /**
     * 节点颜色
     */
    private int color = RED;

    /**
     * 存储的内容
     */
    private T key;

    private RBTreeNode<T> left = (RBTreeNode<T>) NIL_NODE;

    private RBTreeNode<T> right = (RBTreeNode<T>) NIL_NODE;

    private RBTreeNode<T> parent = (RBTreeNode<T>) NIL_NODE;

    private RBTreeNode() {

    }

    public RBTreeNode(T key) {
        this.key = key;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public RBTreeNode<T> getLeft() {
        return left;
    }

    /**
     * 判断节点是否含有子节点（Nil 节点作为空处理）
     *
     * @return true 不含叶子节点
     */
    public boolean hasNoChildren() {
        return NIL_NODE == left && NIL_NODE == right;
    }

    public boolean hasLeftChild() {
        return NIL_NODE != left;
    }

    public boolean hasRightChild() {
        return NIL_NODE != right;
    }

    public boolean hasBothChildren() {
        return hasLeftChild() && hasRightChild();
    }

    public void setLeft(RBTreeNode<T> left) {
        this.left = left;
    }

    public RBTreeNode<T> getRight() {
        return right;
    }

    public void setRight(RBTreeNode<T> right) {
        this.right = right;
    }

    public boolean notLeafNode() {
        return this != NIL_NODE;
    }

    public RBTreeNode<T> getParent() {
        return parent;
    }

    public boolean hasParent() {
        return parent != NIL_NODE;
    }

    public void setParent(RBTreeNode<T> parent) {
        this.parent = parent;
    }

    public boolean isRed() {
        return color == RED;
    }

    public boolean isBlack() {
        return color == BLACK;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
