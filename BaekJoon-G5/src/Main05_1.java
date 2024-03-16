
//No.13549(숨바꼭질 3) - Dijkstra
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main05_1 {
	public static class State implements Comparable<State> {
		public int pos;
		public int time;

		public State(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}

		@Override
		public int compareTo(State n) {
			return this.time - n.time;
		}
	}

	public static int N, K;
	public static int[] isvisited;
	public static int min = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		isvisited = new int[100001];
		Arrays.fill(isvisited, 100000);

		if (N >= K) {
			min = N - K;
		} else {
			dijkstra(N);
			min = isvisited[K];
		}

		System.out.println(min);
	}

	public static void dijkstra(int start) {
		PriorityQueue<State> pq = new PriorityQueue<>();

		pq.offer(new State(start, 0));
		isvisited[start] = 0;

		while (!pq.isEmpty()) {
			State now = pq.poll();

			if (isvisited[now.pos] < now.time) {
				continue;
			}

			int a = now.pos * 2;
			int b = now.pos + 1;
			int c = now.pos - 1;

			if (isRange(a) && isvisited[a] > now.time) {
				isvisited[a] = now.time;
				pq.offer(new State(a, isvisited[a]));
			}

			if (isRange(b) && isvisited[b] > now.time + 1) {
				isvisited[b] = now.time + 1;
				pq.offer(new State(b, isvisited[b]));
			}

			if (isRange(c) && isvisited[c] > now.time + 1) {
				isvisited[c] = now.time + 1;
				pq.offer(new State(c, isvisited[c]));
			}
		}
	}

	public static boolean isRange(int num) {
		return 0 <= num && num <= 100000;
	}
}