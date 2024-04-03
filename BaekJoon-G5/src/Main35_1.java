
//No.9205(맥주 마시면서 걸아가기★)  - 플로이드 워샬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main35_1 {
	private static class Point {
		int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Point> pos = new ArrayList<>();
			boolean[][] search = new boolean[N + 2][N + 2];

			for (int j = 0; j < N + 2; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				pos.add(new Point(x, y));
			}

			for (int j = 0; j < N + 2; j++) {
				for (int k = j + 1; k < N + 2; k++) {
					if (dis(pos.get(j), pos.get(k)) <= 1000) {
						search[j][k] = search[k][j] = true;
					}
				}
			}

			floadW(search, N);

			sb.append(search[0][N + 1] ? "happy" : "sad").append('\n');
		}
		System.out.println(sb);
	}

	public static int dis(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static void floadW(boolean[][] search, int N) {
		for (int k = 0; k < N + 2; k++) {
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (search[i][k] && search[k][j]) {
						search[i][j] = true;
					}
				}
			}
		}
	}
}
