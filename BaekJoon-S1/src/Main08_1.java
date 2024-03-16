
//No.1149(RGB거리)★ - DP (Top-Bottom)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main08_1 {
	public static int N;
	public static int[][] arr;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][3]; // R: 0, G: 1, B: 2
		dp = new int[N][3]; // R: 0, G: 1, B: 2

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];

		System.out.println(Math.min(recur(N - 1, 0), Math.min(recur(N - 1, 1), recur(N - 1, 2))));
	}

	public static int recur(int n, int color) {
		if (dp[n][color] == 0) {
			if (color == 0) {
				return dp[n][0] = Math.min(recur(n - 1, 1), recur(n - 1, 2)) + arr[n][0];
			} else if (color == 1) {
				return dp[n][1] = Math.min(recur(n - 1, 0), recur(n - 1, 2)) + arr[n][1];
			} else {
				return dp[n][2] = Math.min(recur(n - 1, 0), recur(n - 1, 1)) + arr[n][2];
			}
		}

		return dp[n][color];
	}
}