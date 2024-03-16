
//No.1991(트리 순회) - 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21 {
	public static class Node {
		char data;
		Node left, right;

		public Node(char data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static class Tree {
		Node root;

		public void createNode(char data, char left, char right) {
			if (root == null) {
				root = new Node(data);

				if (left != '.') {
					root.left = new Node(left);
				}
				if (right != '.') {
					root.right = new Node(right);
				}
			} else {
				searchNode(root, data, left, right);
			}
		}

		public void searchNode(Node root, char data, char left, char right) {
			if (root == null) {
				return;
			} else if (root.data == data) {
				if (left != '.') {
					root.left = new Node(left);
				}
				if (right != '.') {
					root.right = new Node(right);
				}
			} else {
				searchNode(root.left, data, left, right);
				searchNode(root.right, data, left, right);
			}
		}

		public void preOrder(Node root) {
			sb.append(root.data);
			if (root.left != null) {
				preOrder(root.left);
			}
			if (root.right != null) {
				preOrder(root.right);
			}
		}

		public void inOrder(Node root) {
			if (root.left != null) {
				inOrder(root.left);
			}
			sb.append(root.data);
			if (root.right != null) {
				inOrder(root.right);
			}
		}

		public void postOrder(Node root) {
			if (root.left != null) {
				postOrder(root.left);
			}
			if (root.right != null) {
				postOrder(root.right);
			}
			sb.append(root.data);
		}
	}

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			tree.createNode(a, b, c);
		}

		tree.preOrder(tree.root);
		sb.append('\n');
		tree.inOrder(tree.root);
		sb.append('\n');
		tree.postOrder(tree.root);

		System.out.println(sb);
	}
}
