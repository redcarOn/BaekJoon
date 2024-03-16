
//No.1149(RGB거리)★ - DP (Bottom-Up)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main08 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][3]; // R: 0, G: 1, B: 2
		int[][] dp = new int[N + 1][3]; // R: 0, G: 1, B: 2

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		int cost = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			cost = Math.min(cost, dp[N][i]);
		}

		System.out.println(cost);
	}
}