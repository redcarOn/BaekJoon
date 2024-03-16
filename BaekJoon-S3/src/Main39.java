
//No.2346
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main39 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> idx = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			deque.offerLast(Integer.parseInt(st.nextToken()));
			idx.offerLast(i + 1);
		}

		int count = deque.pollFirst();
		sb.append(idx.pollFirst() + " ");

		while (!deque.isEmpty()) {

			if (count > 0) {
				for (int i = 1; i < count; i++) {
					deque.offerLast(deque.pollFirst());
					idx.offerLast(idx.pollFirst());
				}
				count = deque.pollFirst();
				sb.append(idx.pollFirst() + " ");
			} else {
				for (int i = count; i < -1; i++) {
					deque.offerFirst(deque.pollLast());
					idx.offerFirst(idx.pollLast());
				}
				count = deque.pollLast();
				sb.append(idx.pollLast() + " ");
			}
		}
		System.out.println(sb);
	}
}