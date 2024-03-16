
//No.7576(토마토) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01 {
	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int M, N;
	public static int[][] graph;
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };
	public static int cnt = -1;
	public static Queue<Node> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (check()) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 1) {
					queue.offer(new Node(i, j));
				}
			}
		}

		bfs();

		if (!check()) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node tmp = queue.poll();

				for (int j = 0; j < 4; j++) {
					int tmpr = tmp.r + dr[j];
					int tmpc = tmp.c + dc[j];

					if (!isRange(tmpr, tmpc) || graph[tmpr][tmpc] != 0) {
						continue;
					}

					queue.offer(new Node(tmpr, tmpc));
					graph[tmpr][tmpc] = 1;
				}
			}
			cnt++;
		}
	}

	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}