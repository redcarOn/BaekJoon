
// No.15486(퇴사 2) - 42_1
// DP - 1차원 배열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_15486_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		int[] money = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			if (i + time[i] <= N) {
				dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + money[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}

		System.out.println(dp[N]);
	}
}
