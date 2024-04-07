
// No.21608(상어 초등학교) - 47
// 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G5_21608 {
	static int N;
	static int[][] seat;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		seat = new int[N][N];
		Map<Integer, ArrayList<Integer>> hMap = new HashMap<>();

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int student = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<>();

			for (int j = 0; j < 4; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			hMap.put(student, list);
			func(student, list);
		}

		int ans = level(hMap);
		System.out.println(ans);
	}

	static void func(int student, ArrayList<Integer> list) {
		int maxEmptySeats = -1;
		int maxLikes = -1;
		int maxRow = -1;
		int maxCol = -1;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (seat[r][c] != 0) {
					continue;
				}

				int emptySeats = 0;
				int likes = 0;

				for (int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					if (!isRange(nr, nc)) {
						continue;
					}

					if (list.contains(seat[nr][nc])) {
						likes++;
					}

					if (seat[nr][nc] == 0) {
						emptySeats++;
					}
				}

				if (likes > maxLikes || (likes == maxLikes && emptySeats > maxEmptySeats)) {
					maxLikes = likes;
					maxEmptySeats = emptySeats;
					maxRow = r;
					maxCol = c;
				}
			}
		}
		seat[maxRow][maxCol] = student;
	}

	static int level(Map<Integer, ArrayList<Integer>> hMap) {
		int sum = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int student = seat[r][c];
				int num = 0;

				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];

					if (!isRange(nr, nc)) {
						continue;
					}

					if (hMap.get(student).contains(seat[nr][nc])) {
						num++;
					}
				}

				sum += (int) Math.pow(10, num - 1);
			}
		}
		return sum;
	}

	static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}