
//No.5430(AC) - 덱+문자열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main02 {
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		ArrayDeque<Integer> deque;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			deque = new ArrayDeque<>();

			for (int j = 0; j < n; j++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}

			AC(p, deque);
		}

		System.out.println(sb);
	}

	public static void AC(String p, ArrayDeque<Integer> dq) {
		boolean start = true;

		for (char cmd : p.toCharArray()) {
			if (cmd == 'R') {
				start = !start;
				continue;
			}

			if (start) {
				if (dq.pollFirst() == null) {
					sb.append("error").append('\n');
					return;
				}
			} else {
				if (dq.pollLast() == null) {
					sb.append("error").append('\n');
					return;
				}
			}
		}

		sb.append('[');

		if (dq.size() > 0) {
			if (start) {
				sb.append(dq.pollFirst());

				while (!dq.isEmpty()) {
					sb.append(',').append(dq.pollFirst());
				}
			} else {
				sb.append(dq.pollLast());

				while (!dq.isEmpty()) {
					sb.append(',').append(dq.pollLast());
				}
			}
		}

		sb.append(']').append('\n');
	}
}