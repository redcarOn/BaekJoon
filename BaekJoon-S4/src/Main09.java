
//No.10845
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main09 {
	static int[] queue;
	public static int end = 0;
	public static int start = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		queue = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
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

	public static void push(int x) {
		queue[end] = x;
		end++;
	}

	public static int pop() {
		if (end - start == 0) {
			return -1;
		} else {
			int ans = queue[start];
			queue[start] = 0;
			start++;
			return ans;
		}
	}

	public static int size() {
		return end - start;
	}

	public static int empty() {
		if (end == start) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {
		if (end == start) {
			return -1;
		} else {
			return queue[start];
		}
	}

	public static int back() {
		if (end == start) {
			return -1;
		} else {
			return queue[end - 1];
		}
	}
}