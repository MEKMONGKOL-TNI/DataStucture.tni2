package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {

	private static Node parent = null;
	private Node root;
	private Node DeleteNode;

	public BinaryTree() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	public Node getParent() {
		return parent;
	}
	
	public Node getDeleteNode() {
		return DeleteNode;
	}
	public void printTree(Node node, int depth) {
		if (node != null) {
			printTree(node.right, depth + 1);
			System.out.println("    ".repeat(depth) + node.data);
			printTree(node.left, depth + 1);
		}
	}
	
	public void createTree1() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
	}
	
	public void createTree2() {
		root = new Node(15);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.left.left = new Node(2);
		root.left.right = new Node(11);
		root.right = new Node(23);
		root.right.left = new Node(19);
		root.right.left.right = new Node(20);
	}
	
	public void createTree3() {
		root = new Node(50);
		root.left = new Node(10);
		root.left.left = new Node(11);
		root.left.right = new Node(12);
		root.right = new Node(22);
		root.right.right = new Node(24);
		root.right.right.left = new Node(23);
	}
	


public void createTree4() {
	int[] num = {10, 8, 15, 2, 9, 18, 14, 20, 11, 17};
	
	for (int n : num) {
		insert(n);
	}
}

public void createTree5() {
	int[] num = {50,30,70,10,20,25,40,45,60,55,65};
	
	for (int n : num) {
		insert(n);
	}
}

public void createTree6() {
	int[] num = {40,20,70,30,25,35,32,55,85,80};
	
	for (int i : num) {
		insert(i);
	}
}
public void insert(int new_data) {
	if (root == null) {
		root = new Node(new_data);
	}else {
		Node current_node = root;
		while(true) {
			if (new_data < current_node.data) {
				if(current_node.left == null) {
					current_node.left = new Node(new_data);
					break;
				}
				current_node = current_node.left;
				
			}else {
				if (current_node.right == null) {
					current_node.right = new Node(new_data);
					break;
				}
				current_node = current_node.right;
			}
		}
	}
}

public void searchDeleteNode(int target) {
	Queue<Node> queue = new ArrayDeque<Node>();
	
	queue.add(root);
	while(!queue.isEmpty()) {
		int levelsize = queue.size();
			Node current_node = queue.poll();
			parent = current_node;
			if(parent.data == target) {
				DeleteNode = parent;
				break;
			}
			for (int i=0; i<levelsize; i++) {
				if(current_node.left != null) {
					if (current_node.left.data == target) {
						DeleteNode = current_node.left;
						queue.clear();
						break;
					}
					queue.add(current_node.left);
				}
			}
		}
}


public void delete (int target) {
	searchDeleteNode(target);
	if(root == null) {
		System.out.println("Cannot found the delete node");
	}else {
		if (DeleteNode.left == null && DeleteNode.right == null) {
			if (parent.left != null && parent.left.data == target) {
				parent.right = null;
			} else {
				parent.right = null;
			}
		}
		else if (DeleteNode.left != null && DeleteNode.right != null) {
			Node successorParent = DeleteNode;
			Node successor = DeleteNode.right;
			
			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}
			DeleteNode.data = successor.data;
			
			if (successorParent.left == successor) {
				successorParent.left = successor.right;
			}else {
				successorParent.right = successor.right;
			}
		}
		else {
			if (DeleteNode.left != null) {
				if (parent.left != null && parent.left.data == DeleteNode.data) {
					parent.left = DeleteNode.left;
				}else{
					parent.right = DeleteNode.left;
				}
			}else{
				if (parent.left != null && parent.left.data == DeleteNode.data) {
					parent.left = DeleteNode.right;
				}else{
					parent.right = DeleteNode.right;
			}
		}
	}
		
	}
	
}

}




	


