
//No.17070(파이프 옮기긱 1) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main30_2 {
	public static int N;
	public static int[][] graph;
	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;

		dfs(1, 2, 0);

		System.out.println(cnt);
	}

	public static void dfs(int r, int c, int dir) {
		if (r == N && c == N) {
			cnt++;
			return;
		}

		switch (dir) {
		case 0:
			if (c + 1 <= N && graph[r][c + 1] == 0) {
				dfs(r, c + 1, 0);
			}
			break;
		case 1:
			if (r + 1 <= N && graph[r + 1][c] == 0) {
				dfs(r + 1, c, 1);
			}
			break;

		case 2:
			if (c + 1 <= N && graph[r][c + 1] == 0) {
				dfs(r, c + 1, 0);
			}

			if (r + 1 <= N && graph[r + 1][c] == 0) {
				dfs(r + 1, c, 1);
			}
			break;
		}

		if (r + 1 <= N && c + 1 <= N && graph[r + 1][c] == 0 && graph[r][c + 1] == 0 && graph[r + 1][c + 1] == 0) {
			dfs(r + 1, c + 1, 2);
		}
	}
}