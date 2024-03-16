
//No.1932(정수 삼각형) - DP(Bottom-Up)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N + 1];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0] = arr[0];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					dp[i][j] = arr[i][j] + dp[i - 1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
			}
		}
		int max = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(dp[N - 1][i], max);
		}

		System.out.println(max);
	}
}