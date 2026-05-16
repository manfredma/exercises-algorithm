package manfred.exercises.datastructure.tree.red.black.tree;

/**
 * 红黑树演示：演示红黑树的节点插入和删除操作，并可视化展示树结构变化。
 */
public class RBTreeDemo {

    public static void main(String[] args) {
        RBTree<String> bst = new RBTree<String>();
        bst.addNode("d");
        bst.addNode("d");

        bst.addNode("c");
        bst.addNode("c");

        bst.addNode("b");

        bst.addNode("f");

        bst.addNode("a");

        bst.addNode("e");

        bst.addNode("g");
        bst.addNode("h");
        RBTreeShow.show(bst.getRoot());
        System.out.println("删除节点 g ==================================");
        bst.remove("g");

        RBTreeShow.show(bst.getRoot());

        System.out.println("删除节点 h ==================================");
        bst.remove("h");

        RBTreeShow.show(bst.getRoot());

        System.out.println("删除节点 f ==================================");
        bst.remove("f");

        RBTreeShow.show(bst.getRoot());
    }
}
