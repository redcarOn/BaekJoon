
//No.1010
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12 {
	static int[][] arr = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(Com(M, N) + "\n");
		}
		System.out.print(sb);
	}

	private static int Com(int M, int N) {
		if (arr[M][N] > 0) {
			return arr[M][N];
		}
		if (M == N || N == 0) {
			return arr[M][N] = 1;
		}
		return arr[M][N] = Com(M - 1, N - 1) + Com(M - 1, N);
	}
}