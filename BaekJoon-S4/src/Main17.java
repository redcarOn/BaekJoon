
//NO.10773
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main17 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}

		int sum = 0;
		for (int ans : stack) {
			sum += ans;
		}
		System.out.println(sum);
	}
}