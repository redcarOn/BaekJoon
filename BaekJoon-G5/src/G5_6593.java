
// No.6593(상범 빌딩) - 48
// BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_6593 {
	static int L, R, C;
	static StringBuilder sb;
	static char[][][] building;
	static boolean[][][] visited;
	static int[] df = { 0, 0, 0, 0, -1, 1 };
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 1, -1, 0, 0, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			Point start = new Point(0, 0, 0);
			Point end = new Point(0, 0, 0);

			for (int f = 0; f < L; f++) {
				for (int r = 0; r < R; r++) {
					String s = br.readLine();
					for (int c = 0; c < C; c++) {
						building[f][r][c] = s.charAt(c);

						if (building[f][r][c] == 'S') {
							start = new Point(f, r, c);
						}

						if (building[f][r][c] == 'E') {
							end = new Point(f, r, c);
						}
					}
				}
				br.readLine();
			}

			int num = bfs(start, end);

			if (num == -1) {
				sb.append("Trapped!").append('\n');
			} else {
				sb.append("Escaped in " + num + " minute(s).").append('\n');
			}
		}
		System.out.println(sb.toString());
	}

	static int bfs(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.f][start.r][start.c] = true;
		int time = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Point now = queue.poll();

				int f = now.f;
				int r = now.r;
				int c = now.c;

				if (f == end.f && r == end.r && c == end.c) {
					return time;
				}

				for (int dir = 0; dir < 6; dir++) {
					int nf = f + df[dir];
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					if (!isRange(nf, nr, nc) || building[nf][nr][nc] == '#' || visited[nf][nr][nc]) {
						continue;
					}

					queue.offer(new Point(nf, nr, nc));
					visited[nf][nr][nc] = true;
				}
			}
			time++;
		}
		return -1;
	}

	static boolean isRange(int f, int r, int c) {
		return f >= 0 && r >= 0 && c >= 0 && f < L && r < R && c < C;
	}

	static class Point {
		int f;
		int r;
		int c;

		Point(int f, int r, int c) {
			this.f = f;
			this.r = r;
			this.c = c;
		}
	}
}