
//No.1992(쿼드트리) - 분할정복(재귀)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main26 {
	public static int[][] arr;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();

			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp[j] - '0';
			}
		}

		func(0, 0, N);

		System.out.println(sb);
	}

	public static void func(int x, int y, int size) {
		if (size == 1) {
			sb.append(arr[x][y]);
			return;
		}

		if (!check(x, y, size)) {
			int newSize = size / 2;
			sb.append('(');
			for (int i = 0; i < newSize * 2; i += newSize) {
				for (int j = 0; j < newSize * 2; j += newSize) {
					func(x + i, y + j, newSize);
				}
			}
			sb.append(')');
		} else {
			sb.append(arr[x][y]);
		}
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