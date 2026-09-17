package BinaryTree;

import java.util.Scanner;

public class TreeApp4 {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.createTree6();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        int N = input.nextInt();

        tree.searchDeleteNode(N);

        Node node = tree.getDeleteNode();

        if (node == null) {

            System.out.println("Cannot found Node(data=" + N + ")");

        } else {

            if (node.left != null) {
                System.out.println("Left Child of " + N + " = " + node.left.data);
            } else {
                System.out.println("No Left Child");
            }

            if (node.right != null) {
                System.out.println("Right Child of " + N + " = " + node.right.data);
            } else {
                System.out.println("No Right Child");
            }

            if (node.left == null && node.right == null) {
                System.out.println("[" + N + "] is Leaf Node");
            } else {
                System.out.println("[" + N + "] is not Leaf Node");
            }
        }
    }
}