
//No.5430(AC) - 덱+문자열 - 시간단축
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main02_1 {
	public static char[] P;
	public static ArrayDeque<String> deque;
	public static boolean error;
	public static boolean start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			P = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[,]");
			deque = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				deque.offer(st.nextToken());
			}

			error = false;
			start = true;
			command();

			if (error) {
				sb.append("error").append('\n');
			} else {
				sb.append('[');

				while (!deque.isEmpty()) {
					sb.append(print());
				}

				sb.append(']').append('\n');
			}
		}

		System.out.println(sb);
	}

	public static void command() {
		for (char cmd : P) {
			if (cmd == 'D') {
				if (deque.isEmpty()) {
					error = true;
					return;
				}

				if (start) {
					deque.pollFirst();
				} else {
					deque.pollLast();
				}
			} else {
				start = !start;
			}
		}
	}

	public static String print() {
		StringBuilder tmp = new StringBuilder();

		if (start) {
			while (!deque.isEmpty()) {
				tmp.append(deque.pollFirst()).append(',');
			}
		} else {
			while (!deque.isEmpty()) {
				tmp.append(deque.pollLast()).append(',');
			}
		}

		tmp.deleteCharAt(tmp.length() - 1);

		return tmp.toString();
	}
}