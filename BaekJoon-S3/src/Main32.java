
//No. 17413
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main32 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		String s = br.readLine();
		boolean isOpen = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<' || (s.charAt(i) == ' ' && !isOpen)) {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(s.charAt(i));
				if (s.charAt(i) == '<') {
					isOpen = true;
				}
				continue;
			}
			if (s.charAt(i) == '>') {
				isOpen = false;
				sb.append(s.charAt(i));
				continue;
			}

			if (isOpen) {
				sb.append(s.charAt(i));
			} else {
				stack.push(s.charAt(i));
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}