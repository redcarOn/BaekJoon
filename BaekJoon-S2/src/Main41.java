
//No.2075
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main41 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (pq.size() == N) {
					if (pq.peek() < num) {
						pq.remove();
					} else {
						continue;
					}
				}
				pq.offer(num);
			}
		}
		System.out.println(pq.peek());
	}
}