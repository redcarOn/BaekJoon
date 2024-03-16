
//No.4963 - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18 {
	public static int[][] arr;
	public static boolean[][] isvisited;
	public static int w, h, count;
	public static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 & h == 0) {
				break;
			}

			arr = new int[h][w];
			isvisited = new boolean[h][w];
			count = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && !isvisited[i][j]) {
						DFS(i, j);
						count++;
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static void DFS(int x, int y) {
		isvisited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int x2 = x + dx[i];
			int y2 = y + dy[i];

			if (!area(x2, y2)) {
				continue;
			}

			if (arr[x2][y2] == 1 && !isvisited[x2][y2]) {
				DFS(x2, y2);
			}
		}
	}

	public static boolean area(int x, int y) {
		if (x < 0 || y < 0 || x >= h || y >= w) {
			return false;
		} else {
			return true;
		}
	}
}