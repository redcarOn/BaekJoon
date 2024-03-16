
//No.2447(별 찍기 - 10) - 재귀 + 분할 정복
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15 {
	public static char[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		star = new char[N][N];

		star(0, 0, N, false);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(star[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	public static void star(int x, int y, int N, boolean check) {
		if (check) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					star[i][j] = ' ';
				}
			}
			return;
		}

		if (N == 1) {
			star[x][y] = '*';
			return;
		}

		int size = N / 3;
		int cnt = 0;

		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				cnt++;

				if (cnt == 5) {
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}