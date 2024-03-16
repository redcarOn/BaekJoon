
//No.3184(양) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main63_1 {
	public static int R, C;
	public static char[][] yard;
	public static boolean[][] isvisited;
	public static int s, w;
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		yard = new char[R][C];
		isvisited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			yard[i] = br.readLine().toCharArray();
		}

		int sheep = 0;
		int wolf = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (isvisited[i][j]) {
					continue;
				}
				if (yard[i][j] == 'v' || yard[i][j] == 'o') {
					s = w = 0;
					dfs(i, j);

					if (s > w) {
						sheep += s;
					} else {
						wolf += w;
					}
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	public static void dfs(int r, int c) {
		isvisited[r][c] = true;

		if (yard[r][c] == 'v') {
			w++;
		} else if (yard[r][c] == 'o') {
			s++;
		}

		for (int i = 0; i < 4; i++) {
			int tmpr = r + dr[i];
			int tmpc = c + dc[i];

			if (!isRange(tmpr, tmpc) || isvisited[tmpr][tmpc] || yard[tmpr][tmpc] == '#') {
				continue;
			}

			dfs(tmpr, tmpc);
		}
	}

	public static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}