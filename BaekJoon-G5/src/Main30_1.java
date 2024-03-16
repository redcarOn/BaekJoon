
//No.17070(파이프 옮기긱 1) - DP(3차원)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main30_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N + 1][N + 1][3];

		dp[1][2][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				if (graph[i][j] == 1) {
					continue;
				}

				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

				if (graph[i - 1][j] == 0 && graph[i][j - 1] == 0) {
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}