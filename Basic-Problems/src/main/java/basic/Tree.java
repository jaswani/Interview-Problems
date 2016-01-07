package basic;

import java.util.Stack;

/**
 * Created by jai on 8/18/15.
 * Inorder, Preorder and Postorder traversal of a tree w/o recursion.
 */
public class Tree {
    private class Node {
        public int value;
        public Node left;
        public Node right;
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private void inorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        boolean leftSubTreedone = false;
        while(!stack.isEmpty()) {
            if(!leftSubTreedone && stack.peek().left != null) {
                stack.push(stack.peek().left);
            } else {
                Node current = stack.pop();
                //print current
                System.out.print(current.value + " ");
                if(current.right != null) {
                    stack.push(current.right);
                    leftSubTreedone = false;
                } else {
                    leftSubTreedone = true;
                }
            }
        }
    }

    private void preorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        boolean leftSubTreedone = false;
        while(!stack.isEmpty()) {
            if(!leftSubTreedone) {
                //print current
                System.out.print(stack.peek().value + " ");
            }
            if(!leftSubTreedone && stack.peek().left != null) {
                stack.push(stack.peek().left);
            } else {
                Node current = stack.pop();
                if(current.right != null) {
                    stack.push(current.right);
                    leftSubTreedone = false;
                } else {
                    leftSubTreedone = true;
                }
            }
        }
    }

    private void postorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        boolean leftSubTreedone = false;
        boolean rightSubTreedone = false;
        while(!stack.isEmpty()) {
            if(leftSubTreedone && rightSubTreedone) {
                Node current = stack.pop();
                System.out.print(current.value + " ");
                if(!stack.isEmpty() && stack.peek().right == current) {
                    rightSubTreedone = true;
                } else {
                    rightSubTreedone = false;
                }
            } else if(!leftSubTreedone && stack.peek().left != null) {
                stack.push(stack.peek().left);
            } else {
                Node current = stack.peek();
                if(current.right != null) {
                    stack.push(current.right);
                    leftSubTreedone = false;
                } else {
                    leftSubTreedone = true;
                    rightSubTreedone = true;
                }
            }
        }
    }

    private Node createTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    private void play() {
        Node root = createTree();
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.play();
    }
}
