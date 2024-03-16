
//No.5397 - Stack
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main23 {
	public static Stack<Character> left;
	public static Stack<Character> right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			left = new Stack<>();
			right = new Stack<>();
			String s = br.readLine();

			for (int i = 0; i < s.length(); i++) {
				edit(s, i);
			}

			while (!left.isEmpty()) {
				right.push(left.pop());
			}

			while (!right.isEmpty()) {
				sb.append(right.pop());
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void edit(String s, int i) {
		char c = s.charAt(i);

		switch (c) {
		case '<':
			if (!left.isEmpty()) {
				right.push(left.pop());
			}
			break;

		case '>':
			if (!right.isEmpty()) {
				left.push(right.pop());
			}
			break;

		case '-':
			if (!left.isEmpty()) {
				left.pop();
			}
			break;

		default:
			left.push(c);
			break;
		}
	}
}