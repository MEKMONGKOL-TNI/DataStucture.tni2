public class BinarySearchTree {

	private Node root;
	private Node parent;
	private Node deleteNode;

	public boolean isEmpty() {
		return root == null;
	}

	public void sampleTree1() {
		int[] nums = { 20, 10, 60, 7, 11, 30, 65, 3, 40 };
		for (int num : nums) {
			insert(num);
		}
	}

	public void printTree(Node node, int depth) {
		if (node != null) {
			printTree(node.right, depth + 1);
			System.out.println("    ".repeat(depth) + node.data);
			printTree(node.left, depth + 1);
		}
	}

	public Node getRoot() {
		return root;
	}

	public Node getParent() {
		return parent;
	}

	public Node getDeleteNode() {
		return deleteNode;
	}

	public void insert(int new_data) {
		if (root == null) {
			root = new Node(new_data);
		} else {
			Node current_node = root;

			while (true) {
				if (new_data < current_node.data) {
					if (current_node.left == null) {
						current_node.left = new Node(new_data);
						break;
					}

					current_node = current_node.left;

				} else if (new_data > current_node.data) {
					if (current_node.right == null) {
						current_node.right = new Node(new_data);
						break;
					}

					current_node = current_node.right;

				} else {
					break;
				}
			}
		}
	}

	public int findMinimum() {
		if (isEmpty()) {
			return -1;
		}

		Node current_node = root;

		while (current_node.left != null) {
			current_node = current_node.left;
		}

		return current_node.data;
	}

	public int findMinimum(Node new_root) {
		if (new_root == null) {
			return -1;
		}

		Node current_node = new_root;

		while (current_node.left != null) {
			current_node = current_node.left;
		}

		return current_node.data;
	}

	public int findMaximum() {
		if (isEmpty()) {
			return -1;
		}

		Node current_node = root;

		while (current_node.right != null) {
			current_node = current_node.right;
		}

		return current_node.data;
	}

	public int findMaximum(Node new_root) {
		if (new_root == null) {
			return -1;
		}

		Node current_node = new_root;

		while (current_node.right != null) {
			current_node = current_node.right;
		}

		return current_node.data;
	}

	public boolean findSpecificData(int target) {
		Node current_node = root;

		while (current_node != null) {
			if (target == current_node.data) {
				return true;
			}

			if (target < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}
		}

		return false;
	}

	public void searchDeleteNode(int target) {
		parent = root;
		deleteNode = null;

		Node current_node = root;

		while (current_node != null) {
			if (target == current_node.data) {
				deleteNode = current_node;
				break;
			}

			parent = current_node;

			if (target < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}
		}
	}

	public void delete(int target) {
		if (isEmpty()) {
			System.out.println("Empty Tree");
			return;
		}

		searchDeleteNode(target);

		if (deleteNode == null) {
			System.out.println("Cannot found the delete node");
			return;
		}

		if (deleteNode.left == null && deleteNode.right == null) {

			if (deleteNode == root) {
				root = null;
			} else if (parent.left == deleteNode) {
				parent.left = null;
			} else {
				parent.right = null;
			}

		} else if (deleteNode.left != null && deleteNode.right != null) {

			deleteByLeftSubTree();

		} else {

			Node child;

			if (deleteNode.left != null) {
				child = deleteNode.left;
			} else {
				child = deleteNode.right;
			}

			if (deleteNode == root) {
				root = child;
			} else if (parent.left == deleteNode) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}
	}

	public void deleteByLeftSubTree() {
		Node target = deleteNode;

		int maxValue = findMaximum(deleteNode.left);

		delete(maxValue);

		target.data = maxValue;
	}

	public void deleteByRightSubTree() {
		Node target = deleteNode;

		int minValue = findMinimum(deleteNode.right);

		delete(minValue);

		target.data = minValue;
	}
}