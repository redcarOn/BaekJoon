
//No.15903(카드 합체 놀이) - 우선순위 큐
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main51 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Long> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}

		while (M-- > 0) {
			long a = pq.poll();
			long b = pq.poll();
			long sum = a + b;
			pq.offer(sum);
			pq.offer(sum);
		}

		long ans = 0;

		while (!pq.isEmpty()) {
			ans += pq.poll();
		}

		System.out.println(ans);
	}
}