
//No.18290(NM과 K(1)) - 백트래킹 + 브루트포스 - 시간단축
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main71_1 {
	public static int N, M, K, max, ans;
	public static int[][] arr;
	public static boolean[][] isvisited;
	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		isvisited = new boolean[N][M];
		max = Integer.MIN_VALUE;
		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		dfs(0, 0, 0, 0);

		System.out.println(ans);
	}

	public static void dfs(int r, int c, int sum, int depth) {
		if (sum + ((K - depth) * max) < ans) {
			return;
		}
		if (depth == K) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = r; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isvisited[i][j])
					continue;
				if (i - 1 >= 0 && isvisited[i - 1][j])
					continue;
				if (i + 1 < N && isvisited[i + 1][j])
					continue;
				if (j - 1 >= 0 && isvisited[i][j - 1])
					continue;
				if (j + 1 < M && isvisited[i][j + 1])
					continue;

				isvisited[i][j] = true;
				dfs(i, j, sum + arr[i][j], depth + 1);
				isvisited[i][j] = false;

			}
		}
	}
}