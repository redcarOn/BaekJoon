
//No.15990★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main44 {
	public static final int MOD = 1000000009;
	public static final int N = 100001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[N][4];

		dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

		for (int i = 4; i < N; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
		}

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % MOD).append('\n');
		}
		System.out.println(sb);
	}
}