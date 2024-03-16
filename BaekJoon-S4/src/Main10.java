
//★No.1018
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
	public static boolean[][] arr;
	public static int min = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		
		int arr_row = N - 7;
		int arr_col = M - 7;
		
		for (int i = 0; i < arr_row; i++) {
			for (int j = 0; j < arr_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}

	public static void find(int x, int y) {
		int count = 0;
		boolean start = arr[x][y];

		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {

				if (arr[i][j] != start) {
					count++;
				}
				start = !(start);
			}
			start = !(start);
		}
		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}
}