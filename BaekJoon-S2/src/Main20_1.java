
//No.11051 + Top-Down
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20_1 {
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][K + 1];

		System.out.println(BC(N, K));
	}

	public static int BC(int N, int K) {
		if (arr[N][K] > 0) {
			return arr[N][K];
		}

		if (K == 0 || N == K) {
			return arr[N][K] = 1;
		}

		return arr[N][K] = (BC(N - 1, K - 1) + BC(N - 1, K)) % 10007;
	}
}