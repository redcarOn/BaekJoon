
//No.9251(LCS) - DP + 문자열 (Top-Bottom)★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12_1 {
	public static char[] a, b;
	public static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();

		dp = new Integer[a.length][b.length];

		System.out.println(LCS(a.length - 1, b.length - 1));
	}

	public static int LCS(int x, int y) {
		if (x == -1 || y == -1) {
			return 0;
		}

		if (dp[x][y] == null) {
			dp[x][y] = 0;

			if (a[x] == b[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			} else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}

		return dp[x][y];
	}
}