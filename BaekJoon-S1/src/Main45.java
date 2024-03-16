
//No.1495(기타리스트) - DP★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main45 {
	public static int N, S, M;
	public static int[] arr;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		dp = new int[N][M + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}

		System.out.println(search(0, S));
	}

	public static int search(int idx, int val) {
		if (val > M || val < 0) {
			return -1;
		}

		if (idx == N) {
			return val;
		}

		if (dp[idx][val] != Integer.MIN_VALUE) {
			return dp[idx][val];
		}

		dp[idx][val] = Math.max(dp[idx][val],
				Math.max(search(idx + 1, val + arr[idx]), search(idx + 1, val - arr[idx])));

		return dp[idx][val];
	}
}