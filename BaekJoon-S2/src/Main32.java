
//No.3085
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main32 {
	public static char[][] arr;
	public static int N;
	public static int max = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				swap(i, j, i, j + 1);
				search();
				swap(i, j + 1, i, j);
			}
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				swap(i, j, i + 1, j);
				search();
				swap(i + 1, j, i, j);
			}
		}

		System.out.println(max);
	}

	public static void swap(int x1, int y1, int x2, int y2) {
		char tmp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = tmp;
	}

	public static void search() {
		for (int i = 0; i < N; i++) {
			int count = 1;

			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					count++;
					max = Math.max(count, max);
				} else {
					count = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			int count = 1;

			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					count++;
					max = Math.max(count, max);
				} else {
					count = 1;
				}
			}
		}
	}
}