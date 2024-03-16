
//No.1874
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main06 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int idx = 1;
		
		for (int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			int num = arr[i];

			if (idx > num) {
				if (stack.peek() != num) {
					System.out.println("NO");
					return;
				} else {
					sb.append('-').append('\n');
					stack.pop();
				}
			} else {
				while (idx <= num) {
					sb.append('+').append('\n');
					stack.push(idx);
					idx++;
				}
				stack.pop();
				sb.append('-').append('\n');
			}
		}
		System.out.println(sb);
	}
}