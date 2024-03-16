
//No.1158
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			queue.offer(i + 1);
		}

		sb.append("<");
		while (N > 0) {
			for (int i = 1; i < K; i++) {
				queue.offer(queue.poll());
			}

			if (N == 1) {
				sb.append(queue.poll()).append(">");
			} else {
				sb.append(queue.poll()).append(", ");
			}
			N--;
		}
		System.out.println(sb);
	}
}