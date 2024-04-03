
// No.15486(퇴사 2) - 42
// DP - 2차원 배열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			table[i][0] = Integer.parseInt(st.nextToken());
			table[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			if (i + table[i][0] <= N) {
				dp[i + table[i][0]] = Math.max(dp[i + table[i][0]], dp[i] + table[i][1]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}

		System.out.println(dp[N]);
	}
}
