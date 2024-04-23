import java.util.Arrays;

class Node {
    private Object[] data;
    private Node left;
    private Node right;

    public Node(Object[] data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    //gets left subtree 
    public Node getLeft() {
        return left;
    }
    //sets left subtree
    public void setLeft(Node left) {
        this.left = left;
    }
    //gets right subtree
    public Node getRight() {
        return right;
    }
    //sets right subtree
    public void setRight(Node right) {
        this.right = right;
    }
    //gets node data, using custom dictionary class the first element of 2-d subarray is letter, second element is frequency
    public Object[] getData() {
        return data;
    }

   
    public String toString() {
        return Arrays.toString(data);
    }
}

