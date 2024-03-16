
//No.18290(NM과 K(1)) - 백트래킹 + 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main71 {
	public static int N, M, K;
	public static int[][] arr;
	public static boolean[][] isvisited;
	public static int max = Integer.MIN_VALUE;
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

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0, 0);

		System.out.println(max);
	}

	public static void dfs(int preR, int preC, int sum, int depth) {
		if (depth == K) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = preR; i < N; i++) {
			for (int j = (preR == i ? preC : 0); j < M; j++) {
				if (!isvisited[i][j]) {
					boolean flag = true;

					for (int k = 0; k < 4; k++) {
						int tmpr = i + dr[k];
						int tmpc = j + dc[k];

						if (isRange(tmpr, tmpc) && isvisited[tmpr][tmpc]) {
							flag = false;
							break;
						}
					}

					if (flag) {
						isvisited[i][j] = true;
						dfs(i, j, sum + arr[i][j], depth + 1);
						isvisited[i][j] = false;
					}
				}
			}
		}
	}

	public static boolean isRange(int row, int col) {
		return 0 <= row && 0 <= col && row < N && col < M;
	}
}
