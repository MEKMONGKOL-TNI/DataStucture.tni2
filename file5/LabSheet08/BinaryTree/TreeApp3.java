package BinaryTree;

public class TreeApp3 {
	public static void main(String[] args) {
		System.out.println("-----------------------------------------");
		System.out.println("Binary Tree from createtree5()");
		System.out.println("-----------------------------------------");
		BinaryTree tree = new BinaryTree();
		tree.createTree5();
		tree.printTree(tree.getRoot(), 0);
		
		tree.searchDeleteNode(10);
		System.out.print("Delete Node = " + tree.getDeleteNode().data);
		System.out.print("Parent  = " + tree.getParent().data);
		
		int target = 11;
		tree.delete(target);
		tree.printTree(tree.getRoot(), 0);
}
}