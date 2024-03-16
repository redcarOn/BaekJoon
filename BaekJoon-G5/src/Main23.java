
//No.2011(암호코드) - DP★☆
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main23 {
	public static final int MOD = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		if (s.length() == 0 || s.charAt(0) == '0') {
			System.out.println(0);
			return;
		}

		int[] dp = new int[s.length()];
		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
					dp[i] = dp[i - 1] % MOD;
				} else {
					System.out.println(0);
					return;
				}
			} else {
				if (s.charAt(i - 1) == '0') {
					dp[i] = dp[i - 1] % MOD;
				} else if (i + 1 < s.length() && s.charAt(i + 1) == '0') {
					int k = Integer.parseInt(s.substring(i, i + 2));

					if (k < 27) {
						dp[i] = dp[i - 1] % MOD;
					} else {
						System.out.println(0);
						return;
					}
				} else {
					int k = Integer.parseInt(s.substring(i - 1, i + 1));
					if (k < 27) {
						if (i - 2 >= 0) {
							dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
						} else {
							dp[i] = (dp[i - 1] + 1) % MOD;
						}
					} else {
						dp[i] = dp[i - 1] % MOD;
					}
				}
			}
		}
		System.out.println(dp[s.length() - 1]);
	}
}