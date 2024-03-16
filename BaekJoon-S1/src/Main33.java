
//No.2615(오목) - 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main33 {
	public static final int N = 20;
	public static int[] dx = { 0, 1, 1, 1 };
	public static int[] dy = { 1, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] arr = new int[N][N];

		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt;
		boolean flag = false;

		Loop: for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (arr[j][i] == 0) {
					continue;
				}

				for (int k = 0; k < 4; k++) {
					cnt = 1;
					int tmpx = i;
					int tmpy = j;

					while (true) {
						tmpx += dx[k];
						tmpy += dy[k];

						if (!range(tmpx, tmpy)) {
							break;
						}

						if (arr[j][i] != arr[tmpy][tmpx]) {
							break;
						}

						cnt++;
						if (cnt > 5) {
							break;
						}
					}

					if (range(j - dy[k], i - dx[k])) {
						if (arr[j - dy[k]][i - dx[k]] == arr[j][i]) {
							continue;
						}
					}

					if (cnt == 5) {
						sb.append(arr[j][i]).append('\n');
						sb.append(j + " " + i);
						flag = true;
						break Loop;
					}
				}
			}
		}
		if (!flag) {
			sb.append(0);
		}
		System.out.println(sb);
	}

	public static boolean range(int x, int y) {
		return x > 0 && y > 0 && x < N && y < N;
	}
}