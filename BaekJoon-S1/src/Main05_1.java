
//No.10844(쉬운 계단 수) - DP(Top-Down)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05_1 {
	public static int N;
	public static Long[][] dp;
	public static final long Mod = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new Long[N + 1][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}

		long sum = 0;

		for (int i = 1; i <= 9; i++) {
			sum += recur(N, i);
		}

		System.out.println(sum % Mod);
	}

	public static long recur(int digit, int val) {
		if (digit == 1) {
			return dp[digit][val];
		}

		if (dp[digit][val] == null) {

			if (val == 0) {
				dp[digit][val] = recur(digit - 1, 1);
			}

			else if (val == 9) {
				dp[digit][val] = recur(digit - 1, 8);
			}

			else {
				dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
			}
		}

		return dp[digit][val] % Mod;
	}
}