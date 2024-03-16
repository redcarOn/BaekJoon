
//No.14940(쉬운 최단거리) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main41 {
	public static int N, M;
	public static int[][] arr;
	public static int[][] map;
	public static boolean[][] isvisited;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };

	public static class Node {
		int y;
		int x;
		int cnt;

		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		map = new int[N][M];
		isvisited = new boolean[N][M];
		int x = 0;
		int y = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 2) {
					x = j;
					y = i;
				} else if (arr[i][j] == 0) {
					isvisited[i][j] = true;
				}
			}
		}

		bfs(y, x);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isvisited[i][j] && arr[i][j] == 1) {
					sb.append(-1 + " ");
				} else {
					sb.append(map[i][j] + " ");
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	public static void bfs(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>();
		isvisited[y][x] = true;
		map[y][x] = 0;
		queue.offer(new Node(y, x, 0));

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node tmp = queue.poll();

				for (int j = 0; j < 4; j++) {
					int tmpx = tmp.x + dx[j];
					int tmpy = tmp.y + dy[j];
					int tmpc = tmp.cnt + 1;

					if (!range(tmpx, tmpy) || isvisited[tmpy][tmpx]) {
						continue;
					}

					if (arr[tmpy][tmpx] == 1) {
						isvisited[tmpy][tmpx] = true;
						map[tmpy][tmpx] = tmpc;
						queue.offer(new Node(tmpy, tmpx, tmpc));
					}
				}
			}
		}
	}

	public static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}
}