
//No.1495(기타리스트) - DP★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main45_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		boolean[][] dp = new boolean[N + 1][M + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0][S] = true;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (dp[i - 1][j]) {
					int plus = j + arr[i];
					int minus = j - arr[i];

					if (plus <= M) {
						dp[i][plus] = true;
					}

					if (minus >= 0) {
						dp[i][minus] = true;
					}
				}
			}
		}

		int ans = -1;

		for (int i = M; i >= 0; i--) {
			if (dp[N][i]) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);
	}
}