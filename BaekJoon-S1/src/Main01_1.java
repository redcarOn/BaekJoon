
//No.1697(숨바꼭질) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01_1 {
	public static int[] visited;
	public static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);

		System.out.println(visited[K]);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new int[100001];
		visited[start] = 0;
		queue.offer(start);
		int x, a, b, c;

		while (!queue.isEmpty()) {
			x = queue.poll();

			if (x == K) {
				break;
			}

			a = x - 1;
			b = x + 1;
			c = x * 2;

			if (range(a) && visited[a] == 0) {
				visited[a] = visited[x] + 1;
				queue.offer(a);
			}

			if (range(b) && visited[b] == 0) {
				visited[b] = visited[x] + 1;
				queue.offer(b);
			}

			if (range(c) && visited[c] == 0) {
				visited[c] = visited[x] + 1;
				queue.offer(c);
			}
		}
	}

	public static boolean range(int n) {
		return 0 <= n && n <= 100000;
	}
}