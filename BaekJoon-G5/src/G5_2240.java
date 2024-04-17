
// No.2240(자두나무) - 57
// DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2240 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] plums = new int[T + 1];

		for (int i = 1; i <= T; i++) {
			plums[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[T + 1][W + 1];
		int now = 1;

		for (int i = 1; i <= T; i++) {
			int tree = plums[i];

			for (int j = 0; j <= W; j++) {

				if (j == 0) {
					now = 1;
					if (tree == now) {
						dp[i][j] = dp[i - 1][j] + 1;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
					continue;
				}

				if (j % 2 == 0) {
					now = 1;
					if (now == tree) {
						dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
					}
				} else {
					now = 2;
					if (now == tree) {
						dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= W; i++) {
			max = Math.max(max, dp[T][i]);
		}

		System.out.println(max);
		br.close();
	}
}