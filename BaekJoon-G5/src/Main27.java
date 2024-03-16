
//No.2589(보물섬) - BFS + 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main27 {
	public static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int R, C;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int max = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				visited = new boolean[R][C];
				if (map[i][j] == 'L' ) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		System.out.println(max);
	}

	public static int bfs(int r, int c) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		int cnt = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node tmp = queue.poll();

				for (int j = 0; j < 4; j++) {
					int tmpr = tmp.r + dr[j];
					int tmpc = tmp.c + dc[j];

					if (isRange(tmpr, tmpc) && !visited[tmpr][tmpc] && map[tmpr][tmpc] == 'L') {
						queue.offer(new Node(tmpr, tmpc));
						visited[tmpr][tmpc] = true;
					}
				}
			}
			cnt++;
		}

		return cnt;
	}

	public static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}