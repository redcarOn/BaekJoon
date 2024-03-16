
//No.9251(LCS) - DP + 문자열 (Bottom-Up)★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();

		int lengthA = a.length;
		int lengthB = b.length;
		int[][] dp = new int[lengthA + 1][lengthB + 1];

		for (int i = 1; i <= lengthA; i++) {
			for (int j = 1; j <= lengthB; j++) {

				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[a.length][b.length]);
	}
}