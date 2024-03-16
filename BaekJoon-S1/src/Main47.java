
//No.16926(배열 돌리기 1) - 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main47 {
	public static int N, M, R;
	public static int[][] arr;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Math.min(N, M);

		for (int i = 0; i < R; i++) {
			rotate();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	public static void rotate() {
		for (int i = 0; i < min / 2; i++) {
			int x = i;
			int y = i;
			int tmp = arr[x][y];

			int idx = 0;

			while (idx < 4) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];

				if (isRange(nx, ny, i)) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				} else {
					idx++;
				}
			}
			arr[i + 1][i] = tmp;
		}
	}

	public static boolean isRange(int x, int y, int i) {
		return x >= i && y >= i && x < N - i && y < M - i;
	}
}