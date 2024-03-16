
//No.10866
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main18 {
	public static List<Integer> deque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		deque = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {

			case "push_front":
				int X = Integer.parseInt(st.nextToken());
				push_front(X);
				break;

			case "push_back":
				int Y = Integer.parseInt(st.nextToken());
				push_back(Y);
				break;

			case "pop_front":
				sb.append(pop_front()).append("\n");
				break;

			case "pop_back":
				sb.append(pop_back()).append("\n");
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

	public static void push_front(int X) {
		deque.add(0, X);
	}

	public static void push_back(int X) {
		deque.add(X);
	}

	public static int pop_front() {
		if (deque.isEmpty()) {
			return -1;
		} else {
			int tmp = deque.get(0);
			deque.remove(0);
			return tmp;
		}
	}

	public static int pop_back() {
		if (deque.isEmpty()) {
			return -1;
		} else {
			int tmp = deque.get(deque.size() - 1);
			deque.remove(deque.size() - 1);
			return tmp;
		}
	}

	public static int size() {
		return deque.size();
	}

	public static int empty() {
		if (deque.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {
		if (deque.isEmpty()) {
			return -1;
		} else {
			return deque.get(0);
		}
	}

	public static int back() {
		if (deque.isEmpty()) {
			return -1;
		} else {
			return deque.get(deque.size() - 1);
		}
	}
}