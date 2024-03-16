
//No.1021(Other)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main25_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> deque = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			deque.offerLast(i);
		}

		int count = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int def = 0;

			while (deque.peek() != num) {
				deque.offerLast(deque.poll());
				def++;
			}

			if (def >= (deque.size() + 1) / 2) {
				def = deque.size() - def;
				count += def;
				deque.poll();
			}
		}
		System.out.println(count);
	}
}