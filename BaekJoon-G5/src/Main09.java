
//No.7569(토마토) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main09 {
	public static class Node {
		int h, r, c;

		public Node(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;

		}
	}

	public static int M, N, H;
	public static int[][][] box;
	public static Queue<Node> queue;
	public static int[] dh = { 1, -1, 0, 0, 0, 0 };
	public static int[] dr = { 0, 0, 0, 0, 1, -1 };
	public static int[] dc = { 0, 0, -1, 1, 0, 0 };
	public static int cnt = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이

		box = new int[H][N][M];
		queue = new ArrayDeque<>();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());

					if (box[k][i][j] == 1) {
						queue.offer(new Node(k, i, j));
					}
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

				for (int j = 0; j < 6; j++) {
					int tmph = tmp.h + dh[j];
					int tmpr = tmp.r + dr[j];
					int tmpc = tmp.c + dc[j];

					if (!isRange(tmph, tmpr, tmpc) || box[tmph][tmpr][tmpc] != 0) {
						continue;
					}

					queue.offer(new Node(tmph, tmpr, tmpc));
					box[tmph][tmpr][tmpc] = 1;
				}
			}
			cnt++;
		}
	}

	public static boolean check() {
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[k][i][j] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean isRange(int h, int r, int c) {
		return r >= 0 && c >= 0 && h >= 0 && r < N && c < M && h < H;
	}
}