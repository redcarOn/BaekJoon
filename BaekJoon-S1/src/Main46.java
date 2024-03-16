
//No.1743(음식물 피하기) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main46 {
	public static int N, M, K;
	public static boolean[][] arr;
	public static boolean[][] isvisited;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };

	public static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new boolean[N + 1][M + 1];
		isvisited = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[y][x] = true;
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!isvisited[i][j] && arr[i][j]) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		System.out.println(max);
	}

	public static int bfs(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(y, x));
		isvisited[y][x] = true;
		int cnt = 0;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int tmpy = tmp.y + dy[i];
				int tmpx = tmp.x + dx[i];

				if (isRange(tmpy, tmpx) && !isvisited[tmpy][tmpx] && arr[tmpy][tmpx]) {
					queue.offer(new Node(tmpy, tmpx));
					isvisited[tmpy][tmpx] = true;
				}
			}
		}

		return cnt;
	}

	public static boolean isRange(int y, int x) {
		return y > 0 && x > 0 && y <= N && x <= M;
	}
}