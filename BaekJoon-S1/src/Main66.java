
//No.1446(지름길) - DP(배열) 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main66 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

		int[] dp = new int[D + 1];
		dp[1] = 1;

		for (int i = 2; i < D + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = 0; j < N; j++) {
				if (arr[j][1] == i) {
					dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);
				}
			}
		}

		System.out.println(dp[D]);
	}
}