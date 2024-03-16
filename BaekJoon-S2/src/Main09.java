
//No.1406 - Stack
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main09 {
	public static Stack<Character> left;
	public static Stack<Character> right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		left = new Stack<>();
		right = new Stack<>();

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			edit(s);
		}

		while (!left.isEmpty()) {
			right.push(left.pop());
		}

		while (!right.isEmpty()) {
			sb.append(right.pop());
		}

		System.out.println(sb);
	}

	public static void edit(String s) {
		char c = s.charAt(0);

		switch (c) {
		case 'L':
			if (!left.isEmpty()) {
				right.push(left.pop());
			}
			break;

		case 'D':
			if (!right.isEmpty()) {
				left.push(right.pop());
			}
			break;

		case 'B':
			if (!left.isEmpty()) {
				left.pop();
			}
			break;

		case 'P':
			char x = s.charAt(2);
			left.push(x);
			break;

		default:
			break;
		}
	}
}