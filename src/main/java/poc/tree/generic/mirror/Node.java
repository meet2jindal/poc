package poc.tree.generic.mirror;

import java.util.List;
import java.util.stream.Collectors;


public class Node {
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
