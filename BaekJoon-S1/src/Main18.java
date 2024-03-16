
//No.11660(구간 합 구하기 5) - DP(1줄)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18 {
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				dp[i][j] = num + dp[i][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sb.append(find(x1, y1, x2, y2)).append('\n');
		}

		System.out.println(sb);
	}

	public static int find(int x1, int y1, int x2, int y2) {
		int sum = 0;

		for (int i = x1; i <= x2; i++) {
			sum += dp[i][y2] - dp[i][y1 - 1];
		}

		return sum;
	}
}