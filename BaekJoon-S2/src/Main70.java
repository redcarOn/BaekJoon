
//No.1535(안녕) - 2차원배열★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main70 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int hp = 100;
		int N = Integer.parseInt(br.readLine());
		int[] life = new int[N + 1];
		int[] laugh = new int[N + 1];
		int[][] dp = new int[N + 1][hp];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			life[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			laugh[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < hp; j++) {
				if (life[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j - life[i]] + laugh[i], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N][hp - 1]);
	}
}