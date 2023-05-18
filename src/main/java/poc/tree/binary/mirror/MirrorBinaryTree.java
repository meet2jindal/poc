package poc.tree.binary.mirror;

public class MirrorBinaryTree {
    public static void main(String[] args) {
        Node root = prepareTree();
        printTree(root);

        System.out.println("\nMirrored Tree");
        root = mirrorTree(root);
        printTree(root);
    }

    private static Node prepareTree() {
        Node root = new Node();
        root.setData(10);

        Node node20 = getNode(20);
        Node node30 = getNode(30);
        root.setLeft(node20);
        root.setRight(node30);

        Node node40 = getNode(40);
        Node node50 = getNode(50);
        node20.setLeft(node40);
        node20.setRight(node50);


        Node node60 = getNode(60);
        Node node70 = getNode(70);
        node30.setLeft(node60);
        node30.setRight(node70);

        return root;
    }

    private static Node mirrorTree(Node root) {
        if (root.getLeft() != null || root.getRight() != null) {
            swap(root);
            mirrorTree(root.getLeft());
            mirrorTree(root.getRight());
        }
        return root;
    }

    private static void swap(Node node) {
        if (node != null) {
            Node temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
    }

    private static Node getNode(int data) {
        Node node = new Node();
        node.setData(data);
        return node;
    }

    private static int getData(Node node) {
        if (node != null) {
            return node.getData();
        }
        return -1;
    }

    private static void printTree(Node root) {
        if (root != null) {
            System.out.println(getData(root) + "->" + getData(root.getLeft()) + ", " + getData(root.getRight()));
            printTree(root.getLeft());
            printTree(root.getRight());
        }
       /* if (root.getChildren() != null && root.getChildren().size() > 0) {
            root.printChildren();
            for (poc.tree.generic.mirror.Node child : root.getChildren()) {


            }
        }*/

    }
}
