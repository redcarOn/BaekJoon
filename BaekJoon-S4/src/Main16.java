
//No.18258
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16 {
	public static int[] stack;
	public static int start = 0;
	public static int end = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		stack = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {

			case "push":
				int X = Integer.parseInt(st.nextToken());
				push(X);
				break;

			case "pop":
				sb.append(pop()).append("\n");
				break;

			case "size":
				sb.append(size()).append("\n");
				break;

			case "empty":
				sb.append(empty()).append("\n");
				break;

			case "front":
				sb.append(front()).append("\n");
				break;

			case "back":
				sb.append(back()).append("\n");
				break;
			}

		}
		System.out.println(sb);
	}

	public static void push(int X) {
		stack[end] = X;
		end++;
	}

	public static int pop() {
		if (stack[start] == 0) {
			return -1;
		} else {
			int tmp = stack[start];
			start++;
			return tmp;
		}
	}

	public static int size() {
		return end - start;
	}

	public static int empty() {
		if (start == end) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {
		if (start == end) {
			return -1;
		} else {
			return stack[start];
		}
	}

	public static int back() {
		if (start == end) {
			return -1;
		} else {
			return stack[end - 1];
		}
	}
}