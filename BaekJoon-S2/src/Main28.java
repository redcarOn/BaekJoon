
//No.10799
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main28 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		int count = 0;
		char tmp = 0;
		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ')') {
				if (!stack.isEmpty()) {
					if (tmp == ')') {
						stack.pop();
						count += 1;
					} else {
						stack.pop();
						count += stack.size();
					}
				}
			} else {
				stack.push(c);
			}
			tmp = c;
		}

		System.out.println(count);
	}
}