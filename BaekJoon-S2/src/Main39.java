
//No.15988
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main39 {
	public static final int MOD = 1000000009;
	public static final int N = 1000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[N];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
		}

		while (T-- > 0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
		}

		System.out.println(sb);
	}
}