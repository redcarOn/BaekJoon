
//No.2504(괄호의 값) - 스택 + 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main20 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		char[] s = br.readLine().toCharArray();
		int ans = 0;
		int sum = 1;

		for (int i = 0; i < s.length; i++) {
			if (s[i] == '(') {
				sum *= 2;
				stack.push(s[i]);
			} else if (s[i] == '[') {
				sum *= 3;
				stack.push(s[i]);
			} else if (s[i] == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					ans = 0;
					break;
				} else if (s[i - 1] == '(') {
					ans += sum;
				}
				sum /= 2;
				stack.pop();
			} else if (s[i] == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					ans = 0;
					break;
				} else if (s[i - 1] == '[') {
					ans += sum;
				}
				sum /= 3;
				stack.pop();
			}
		}

		if (!stack.isEmpty()) {
			ans = 0;
		}

		System.out.println(ans);
	}
}