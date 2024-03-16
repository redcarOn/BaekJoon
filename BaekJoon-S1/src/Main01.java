
//No.1697(숨바꼭질) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01 {
	public static boolean[] visited;
	public static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N));
	}

	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[100001];
		visited[start] = true;
		queue.offer(start);
		int count = 0;
		int size, tmp, a, b, c;

		while (!queue.isEmpty()) {
			size = queue.size();

			for (int i = 0; i < size; i++) {
				tmp = queue.poll();

				if (tmp == K) {
					return count;
				}

				a = tmp - 1;
				b = tmp + 1;
				c = tmp * 2;

				if (range(a) && !visited[a]) {
					visited[a] = true;
					queue.offer(a);
				}

				if (range(b) && !visited[b]) {
					visited[b] = true;
					queue.offer(b);
				}

				if (range(c) && !visited[c]) {
					visited[c] = true;
					queue.offer(c);
				}
			}
			count++;
		}
		return -1;
	}

	public static boolean range(int n) {
		return 0 <= n && n <= 100000;
	}
}