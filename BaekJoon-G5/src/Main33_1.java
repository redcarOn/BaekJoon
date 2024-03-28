
//No.2565(전깃줄) - DP, LIS (Top-Down)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main33_1 {
	private static int[][] arr;
	private static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new Integer[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (int[] o1, int[] o2) -> o1[0] - o2[0]);

		int max = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, recur(i));
		}

		System.out.println(N - max);
	}

	public static int recur(int N) {
		if (dp[N] == null) {
			dp[N] = 1;

			for (int i = N + 1; i < dp.length; i++) {
				if (arr[N][1] < arr[i][1]) {
					dp[N] = Math.max(dp[N], recur(i) + 1);
				}
			}
		}

		return dp[N];
	}
}