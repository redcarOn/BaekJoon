
//No.12789
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main49 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(snack(arr));
	}

	public static String snack(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int idx = 1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != idx) {

				if (!stack.isEmpty() && stack.peek() == idx) {
					stack.pop();
					i--;
					idx++;
				} else {
					stack.push(arr[i]);
				}
			} else {
				idx++;
			}
		}
		boolean result = true;

		for (int i = 0; i < stack.size(); i++) {
			int tmp = stack.pop();

			if (tmp == idx) {
				idx++;
			} else {
				result = false;
				break;
			}
		}
		return result ? "Nice" : "Sad";
	}
}