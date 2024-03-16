
//No.10026(적록색약) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main17 {
	public static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int N;
	public static char[][] graph;
	public static boolean[][] visited;
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		graph = new char[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		visited = new boolean[N][N];
		int cnt1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs1(i, j, graph[i][j]);
					cnt1++;
				}
			}
		}

		visited = new boolean[N][N];
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs2(i, j, graph[i][j]);
					cnt2++;
				}
			}
		}

		sb.append(cnt1).append(" ").append(cnt2);

		System.out.println(sb);
	}

	public static void bfs1(int r, int c, char color) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int tmpr = tmp.r + dr[i];
				int tmpc = tmp.c + dc[i];

				if (!isRange(tmpr, tmpc) || visited[tmpr][tmpc] || graph[tmpr][tmpc] != color) {
					continue;
				}

				queue.offer(new Node(tmpr, tmpc));
				visited[tmpr][tmpc] = true;
			}
		}
	}

	public static void bfs2(int r, int c, char color) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		boolean flag = color == 'B' ? true : false;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int tmpr = tmp.r + dr[i];
				int tmpc = tmp.c + dc[i];

				if (!isRange(tmpr, tmpc) || visited[tmpr][tmpc]) {
					continue;
				}

				if (flag) {
					if (graph[tmpr][tmpc] == 'B') {
						queue.offer(new Node(tmpr, tmpc));
						visited[tmpr][tmpc] = true;
					}
				} else {
					if (graph[tmpr][tmpc] != 'B') {
						queue.offer(new Node(tmpr, tmpc));
						visited[tmpr][tmpc] = true;
					}
				}
			}
		}
	}

	public static boolean isRange(int r, int c) {
		return 0 <= r && 0 <= c && r < N && c < N;
	}
}