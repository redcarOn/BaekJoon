
// No.6198(옥상 정원 꾸미기) - 55
// 스택
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G5_6198 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		long result = 0;

		for (int i = 0; i < N; i++) {
			int building = Integer.parseInt(br.readLine());

			while (!stack.isEmpty() && stack.peek() <= building) {
				stack.pop();
			}

			result += stack.size();
			stack.push(building);
		}

		System.out.println(result);
	}
}