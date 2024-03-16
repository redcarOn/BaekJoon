
//No.13549(숨바꼭질 3) - BFS★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main05 {
	public static int N, K;
	public static int[] isvisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		isvisited = new int[100001];
		Arrays.fill(isvisited, -1);
		bfs(N);

		System.out.println(isvisited[K]);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		isvisited[start] = 0;

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			if (tmp == K) {
				break;
			}

			int a = tmp * 2;
			int b = tmp + 1;
			int c = tmp - 1;

			if (isRange(a)) {
				if (isvisited[a] == -1 || isvisited[a] > isvisited[tmp]) {
					queue.offer(a);
					isvisited[a] = isvisited[tmp];
				}
			}

			if (isRange(b)) {
				if (isvisited[b] == -1 || isvisited[b] > isvisited[tmp] + 1) {
					queue.offer(b);
					isvisited[b] = isvisited[tmp] + 1;
				}
			}

			if (isRange(c)) {
				if (isvisited[c] == -1 || isvisited[c] > isvisited[tmp] + 1) {
					queue.offer(c);
					isvisited[c] = isvisited[tmp] + 1;
				}
			}
		}
	}

	public static boolean isRange(int num) {
		return 0 <= num && num <= 100000;
	}
}