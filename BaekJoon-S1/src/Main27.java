
//No.1890(점프) - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main27 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		long[][] dp = new long[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] == 0 || arr[i][j] == 0) {
					continue;
				}
				int num = arr[i][j];
				if (i + num < N) {
					dp[i + num][j] += dp[i][j];
				}
				if (j + num < N) {
					dp[i][j + num] += dp[i][j];
				}
			}
		}

		System.out.println(dp[N - 1][N - 1]);
	}
}