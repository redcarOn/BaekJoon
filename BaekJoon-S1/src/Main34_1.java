
//No.1309(동물원) - DP★(1차원 배열)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main34_1 {
	public static final int MOD = 9901;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];

		dp[0] = 1;
		dp[1] = 3;

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % MOD;
		}

		System.out.println(dp[N]);
	}
}