
//No.4949
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main08 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;

		while (true) {
			s = br.readLine();

			if (s.equals(".")) {
				break;
			}
			sb.append(solve(s)).append("\n");
		}
		System.out.print(sb);
	}

	public static String solve(String s) {
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i + 1);

			if (c.equals("[") || c.equals("(")) {
				stack.push(c);

			} else if (c.equals("]")) {
				if (stack.empty() || !(stack.peek()).equals("[")) {
					return "no";
				} else {
					stack.pop();
				}

			} else if (c.equals(")")) {
				if (stack.empty() || !(stack.peek()).equals("(")) {
					return "no";
				} else {
					stack.pop();
				}
			}
		}
		if (stack.empty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}