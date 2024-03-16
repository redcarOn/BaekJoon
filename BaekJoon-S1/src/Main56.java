
//No.16918(봄버맨) - 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main56 {
	public static int R, C;
	public static char[][] arr;
	public static int[][] bomb;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		bomb = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'O') {
					bomb[i][j] = 3;
				}
			}
		}

		check(N);

		for (int i = 0; i < R; i++) {
			sb.append(arr[i]).append('\n');
		}

		System.out.println(sb);
	}

	public static void check(int N) {
		int time = 0;

		while (time++ < N) {
			if (time % 2 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (arr[i][j] == '.') {
							arr[i][j] = 'O';
							bomb[i][j] = time + 3;
						}
					}
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (bomb[i][j] == time) {
							arr[i][j] = '.';
							for (int d = 0; d < 4; d++) {
								int ny = i + dy[d];
								int nx = j + dx[d];

								if (!isRange(ny, nx)) {
									continue;
								}

								if (arr[ny][nx] == 'O' && bomb[ny][nx] != time) {
									arr[ny][nx] = '.';
									bomb[ny][nx] = 0;
								}
							}
						}
					}
				}
			}
		}
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < R && x < C;
	}
}
