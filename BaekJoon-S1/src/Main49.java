
//No.10164(격자상의 경로) - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main49 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][M + 1];

		int cnt = 0;
		int x = 0, y = 0;
		boolean flag = false;

		dp[1][0] = 1;

		Loop: for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cnt++;
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				if (cnt == K) {
					flag = true;
					y = i;
					x = j;
					break Loop;
				}
			}
		}

		if (flag) {
			for (int i = y; i <= N; i++) {
				for (int j = x; j <= M; j++) {
					if (i > y) {
						dp[i][j] += dp[i - 1][j];
					}
					if (j > x) {
						dp[i][j] += dp[i][j - 1];
					}
				}
			}
		}

		System.out.println(dp[N][M]);
	}
}