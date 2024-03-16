
//No.14503(로봇 청소기) - 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19 {
	public static int N, M;
	public static int[][] room;
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(r, c, d);

		System.out.println(cnt);
	}

	public static void func(int r, int c, int dir) {
		room[r][c] = -1;

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (isRange(nr, nc) && room[nr][nc] == 0) {
				cnt++;
				func(nr, nc, dir);
				return;
			}
		}

		int back = (dir + 2) % 4;
		int br = r + dr[back];
		int bc = c + dc[back];

		if (isRange(br, bc) && room[br][bc] != 1) {
			func(br, bc, dir);
		}
	}

	public static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}