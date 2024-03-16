
//No.1935
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main38 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		Map<Character, Double> hMap = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();

		for (int i = 0; i < N; i++) {
			double num = Integer.parseInt(br.readLine());
			hMap.put((char) ('A' + i), num);
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 'A' >= 0) {
				stack.push(hMap.get(s.charAt(i)));
			} else {
				if (!stack.empty()) {
					double b = stack.pop();
					double a = stack.pop();
					if (s.charAt(i) == '+') {
						stack.push(a + b);
					} else if (s.charAt(i) == '-') {
						stack.push(a - b);
					} else if (s.charAt(i) == '*') {
						stack.push(a * b);
					} else if (s.charAt(i) == '/') {
						stack.push(a / b);
					}
				}
			}
		}
		double ans = 0;
		if (!stack.isEmpty()) {
			ans = stack.pop();
		}
		System.out.printf("%.2f", ans);
	}
}