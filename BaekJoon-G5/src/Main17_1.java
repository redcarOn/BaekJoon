
//No.10026(적록색약) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17_1 {
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
					dfs(i, j, graph[i][j]);
					cnt1++;
				}

				if (graph[i][j] == 'G') {
					graph[i][j] = 'R';
				}
			}
		}

		visited = new boolean[N][N];
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, graph[i][j]);
					cnt2++;
				}
			}
		}

		sb.append(cnt1).append(" ").append(cnt2);

		System.out.println(sb);
	}

	public static void dfs(int r, int c, char color) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int tmpr = r + dr[i];
			int tmpc = c + dc[i];

			if (!isRange(tmpr, tmpc) || visited[tmpr][tmpc] || graph[tmpr][tmpc] != color) {
				continue;
			}
			dfs(tmpr, tmpc, color);
		}
	}

	public static boolean isRange(int r, int c) {
		return 0 <= r && 0 <= c && r < N && c < N;
	}
}