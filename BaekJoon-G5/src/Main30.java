
//No.17070(파이프 옮기긱 1) - DP(클래스)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main30 {
	public static class check {
		int r, c, rc;

		public check(int r, int c, int rc) {
			this.r = r;
			this.c = c;
			this.rc = rc;
		}
	}

	public static int N;
	public static int[][] graph;
	public static check[][] dp;

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

		dp = new check[N + 1][N + 1];

		dp[1][2] = new check(1, 0, 0);

		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				if (graph[i][j] == 1) {
					continue;
				}

				int x = 0;
				int y = 0;
				int z = 0;

				if (dp[i][j - 1] != null) {
					x = dp[i][j - 1].r + dp[i][j - 1].rc;
				}
				if (dp[i - 1][j] != null) {
					y = dp[i - 1][j].c + dp[i - 1][j].rc;
				}

				if (dp[i - 1][j - 1] != null && graph[i - 1][j] != 1 && graph[i][j - 1] != 1) {
					z = dp[i - 1][j - 1].r + dp[i - 1][j - 1].c + dp[i - 1][j - 1].rc;
				}

				dp[i][j] = new check(x, y, z);
			}
		}
		int cnt = 0;

		if (dp[N][N] != null) {
			cnt = dp[N][N].c + dp[N][N].r + dp[N][N].rc;
		}

		System.out.println(cnt);
	}
}