
// No.13398(연속합 2) - 43
// DP - 단방향 2차원배열 (양방향해서도 가능)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_13398 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][2];
		dp[0][0] = arr[0];
		int max = arr[0];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(arr[i], dp[i-1][0]+arr[i]);
			dp[i][1]=Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(max);
	}
}