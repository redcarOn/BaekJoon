
//No.7562(나이트의 이동) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main20 {
	public static class knight {
		int x;
		int y;
		int cnt;

		public knight(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	public static boolean[][] isvisited;
	public static int l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			l = Integer.parseInt(br.readLine());
			isvisited = new boolean[l][l];

			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			if (x1 == x2 && y1 == y2) {
				sb.append(0).append('\n');
				continue;
			}

			sb.append(find(x1, y1, x2, y2)).append('\n');
		}

		System.out.println(sb);
	}

	public static int find(int x1, int y1, int x2, int y2) {
		Queue<knight> queue = new ArrayDeque<>();
		queue.offer(new knight(x1, y1, 0));
		isvisited[x1][y1] = true;

		while (!queue.isEmpty()) {
			knight tmp = queue.poll();

			for (int i = 0; i < 8; i++) {
				int tmpx = tmp.x + dx[i];
				int tmpy = tmp.y + dy[i];
				int count = tmp.cnt + 1;

				if (tmpx == x2 && tmpy == y2) {
					return count;
				}

				if (!range(tmpx, tmpy)) {
					continue;
				}

				if (isvisited[tmpx][tmpy]) {
					continue;
				}

				isvisited[tmpx][tmpy] = true;
				queue.offer(new knight(tmpx, tmpy, count));
			}
		}
		return -1;
	}

	public static boolean range(int x, int y) {
		return 0 <= x && 0 <= y && x < l && y < l;
	}
}