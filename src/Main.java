public class Main {
    public static void main(String[] args) {
    BST tree = new BST();

    tree.add(4);
    tree.add(2);
    tree.add(1);
    tree.add(3);
    tree.add(6);
    tree.add(5);
    tree.add(7);
    System.out.println(tree.height());
    System.out.println(tree.countNodes());
    System.out.println(tree.countLeafNodes());
    System.out.println(tree.contains(3));
    System.out.println(tree.contains(10));
    System.out.println(tree.preorder());
    System.out.println(tree.postorder());
    System.out.println(tree.inorder());
    tree.delete(2);


    }
}
