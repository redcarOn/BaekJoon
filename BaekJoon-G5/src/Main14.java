
//No.2493(탑) - 스택
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14 {
	public static class Node {
		int n;
		int h;

		public Node(int n, int h) {
			this.n = n;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Node> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		stack.push(new Node(0, 0));
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (true) {
				if (stack.isEmpty()) {
					sb.append(0).append(" ");
					stack.push(new Node(i, num));
					break;
				} else {
					Node tmp = stack.peek();
					if (tmp.h > num) {
						sb.append(tmp.n).append(" ");
						stack.push(new Node(i, num));
						break;
					} else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb);
	}
}