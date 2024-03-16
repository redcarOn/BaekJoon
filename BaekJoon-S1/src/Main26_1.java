
//No.1992(쿼드트리) - 분할정복(재귀 다른방식) 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main26_1 {
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
		if (check(x, y, size)) {
			sb.append(arr[x][y]);
			return;
		}

		int newSize = size / 2;

		sb.append('(');
		func(x, y, newSize);
		func(x, y + newSize, newSize);
		func(x + newSize, y, newSize);
		func(x + newSize, y + newSize, newSize);
		sb.append(')');
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