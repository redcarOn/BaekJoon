
//No.2630
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main34 {
	public static int N;
	public static int[][] arr;
	public static int[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		color = new int[2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(0, 0, N);

		for (int idx : color) {
			sb.append(idx).append('\n');
		}

		System.out.println(sb);
	}

	public static void recur(int x, int y, int size) {
		if (size == 1) {
			color[arr[x][y]]++;
			return;
		}

		if (!check(x, y, size)) {
			int newSize = size / 2;

			for (int i = 0; i < newSize * 2; i += newSize) {
				for (int j = 0; j < newSize * 2; j += newSize) {
					recur(x + i, y + j, newSize);
				}
			}
			return;
		}
		color[arr[x][y]]++;
	}

	public static boolean check(int x, int y, int size) {
		int num = arr[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (num != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}