package poc.tree.generic.mirror;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MirrorGenericTree {

    public static void main(String[] args) {
        Node root = prepareTree();
        printTree(root);

        System.out.println("\nMirrored Tree");
        root  = mirrorTree(root);
        printTree(root);


    }

    public static Node mirrorTree(Node root) {
        if (root.getChildren() != null && root.getChildren().size() > 0) {
            for (Node child : root.getChildren()) {
                mirrorTree(child);
            }
            Collections.reverse(root.getChildren());
        }

        return root;
    }

    private static Node getNode(int data) {
        Node node = new Node();
        node.setData(data);
        return node;
    }

    private static Node prepareTree() {
        Node root = new Node();
        root.setData(10);

        Node node20 = getNode(20);
        Node node30 = getNode(30);
        Node node40 = getNode(40);

        root.setChildren(Arrays.asList(node20, node30, node40));

        Node node50 = getNode(50);
        Node node60 = getNode(60);
        node20.setChildren(Arrays.asList(node50, node60));

        Node node70 = getNode(70);
        Node node80 = getNode(80);
        node30.setChildren(Arrays.asList(node70, node80));

        Node node90 = getNode(90);
        node40.setChildren(Arrays.asList(node90));
        return root;
    }

    private static void printTree(Node root) {
        System.out.println("");
        System.out.print(root.getData() + "->");
        if (root.getChildren() != null && root.getChildren().size() > 0) {
            root.printChildren();
            for (Node child : root.getChildren()) {

                printTree(child);
            }
        }

    }
    private static class Node {
        int data;
        List<Node> children;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", children=" + children +
                    '}';
        }

        public void printChildren() {
            if (this.getChildren() != null && this.getChildren().size() > 0) {
                final String collect = this.getChildren().stream()
                        .map(child -> String.valueOf(child.getData()))
                        .collect(Collectors.joining(","));
                System.out.print(collect);
            }
        }
    }
}
