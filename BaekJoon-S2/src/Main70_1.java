
//No.1535(안녕) - 1차원배열★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main70_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] life = new int[N + 1];
		int[] laugh = new int[N + 1];
		int[] dp = new int[100];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			life[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			laugh[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 99; j >= life[i]; j--) {
				dp[j] = Math.max(dp[j - life[i]] + laugh[i], dp[j]);
			}
		}
		System.out.println(dp[99]);
	}
}