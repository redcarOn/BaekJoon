
//No.1966
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] print = new int[N];
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				print[j] = Integer.parseInt(st.nextToken());
				pq.offer(print[j]);
			}

			int count = 0;
			int idx = 0;

			while (!pq.isEmpty()) {
				int tmp = pq.poll();

				while (print[idx] != tmp) {
					idx++;
					if (idx == N) {
						idx = 0;
					}
				}

				if (print[idx] == tmp) {
					count++;
					if (idx == M) {
						break;
					}
					idx++;
					if (idx == N) {
						idx = 0;
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}