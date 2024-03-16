
//No.9012
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main04 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			sb.append(Vps(s)).append("\n");
		}
		System.out.print(sb);
	}

	public static String Vps(String s) {
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i + 1);

			if (c.equals("(")) {
				stack.push(c);
			} else if (stack.empty()) {
				return "NO";
			} else {
				stack.pop();
			}
		}
		if (stack.empty()) {
			return "YES";
		} else {
			return "NO";
		}
	}
}