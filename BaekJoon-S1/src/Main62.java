
//No.2502(떡 먹는 호랑이) - DP + 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main62 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[D + 1][2];
		dp[1][0] = 1;
		dp[2][1] = 1;

		for (int i = 3; i <= D; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}

		int idx = 1;

		while (true) {
			int num = K - dp[D][0] * idx;
			if (num % dp[D][1] == 0) {
				sb.append(idx).append('\n').append(num / dp[D][1]);
				break;
			} else {
				idx++;
			}
		}

		System.out.println(sb);
	}
}