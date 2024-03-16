
//No.5539(이진 검색 트리) - 트리
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main28 {
	public static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static class Tree {
		Node root;

		public void createNode(int data) {
			if (root == null) {
				root = new Node(data);
			} else {
				searchNode(root, data);
			}
		}

		public void searchNode(Node root, int data) {
			if (root == null) {
				return;
			} else if (root.data > data) {
				if (root.left == null) {
					root.left = new Node(data);
				} else {
					searchNode(root.left, data);
				}
			} else if (root.data < data) {
				if (root.right == null) {
					root.right = new Node(data);
				} else {
					searchNode(root.right, data);
				}
			}
		}

		public void postOrder(Node root) {
			if (root.left != null) {
				postOrder(root.left);
			}
			if (root.right != null) {
				postOrder(root.right);
			}

			sb.append(root.data).append('\n');
		}
	}

	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		Tree tree = new Tree();
		String input = "";

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int num = Integer.parseInt(input);

			tree.createNode(num);
		}

		tree.postOrder(tree.root);

		System.out.println(sb);
	}
}