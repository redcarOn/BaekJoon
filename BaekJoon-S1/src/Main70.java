
//No.4883(삼각 그래프) - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main70 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int idx = 0;

		while (true) {
			int N = Integer.parseInt(br.readLine());
			idx++;

			if (N == 0) {
				break;
			}

			int[][] graph = new int[N][3];
			int[][] dp = new int[N][3];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = graph[0][1];
			dp[0][2] = dp[0][1] + graph[0][2];
			dp[1][0] = dp[0][1] + graph[1][0];
			dp[1][1] = Math.min(dp[0][1], Math.min(dp[1][0], dp[0][2])) + graph[1][1];
			dp[1][2] = Math.min(dp[0][1], Math.min(dp[0][2], dp[1][1])) + graph[1][2];

			for (int i = 2; i < N; i++) {
				dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + graph[i][0];
				dp[i][1] = Math.min(Math.min(dp[i - 1][0], dp[i][0]), Math.min(dp[i - 1][1], dp[i - 1][2]))
						+ graph[i][1];
				dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i][1]), dp[i - 1][2]) + graph[i][2];
			}

			sb.append(idx).append(". ").append(dp[N - 1][1]).append('\n');
		}
		System.out.println(sb);
	}
}