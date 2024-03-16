
//No.3184(양) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main63 {
	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int R, C;
	public static char[][] yard;
	public static boolean[][] isvisited;
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };
	public static int sheep, wolf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		yard = new char[R][C];
		isvisited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				yard[i][j] = s.charAt(j);
			}
		}

		sheep = 0;
		wolf = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (yard[i][j] != '#' && !isvisited[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	public static void bfs(int r, int c) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(r, c));
		isvisited[r][c] = true;
		int s = 0;
		int w = 0;
		if (yard[r][c] == 'v') {
			w++;
		} else if (yard[r][c] == 'o') {
			s++;
		}

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int tmpr = tmp.r + dr[i];
				int tmpc = tmp.c + dc[i];

				if (!isRange(tmpr, tmpc) || isvisited[tmpr][tmpc] || yard[tmpr][tmpc] == '#') {
					continue;
				}

				if (yard[tmpr][tmpc] == 'v') {
					w++;
				} else if (yard[tmpr][tmpc] == 'o') {
					s++;
				}

				queue.offer(new Node(tmpr, tmpc));
				isvisited[tmpr][tmpc] = true;
			}
		}

		if (s > w) {
			sheep += s;
		} else {
			wolf += w;
		}
	}

	public static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}