
//No.1051
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main42 {
	public static void main(String[] ars) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = (int) (s.charAt(j) - '0');
			}
		}

		int count = 1;
		int size = Math.min(N, M);

		Loop: while (size > 1) {
			for (int i = 0; i <= N - size; i++) {
				for (int j = 0; j <= M - size; j++) {
					int tmp = arr[i][j];
					if (tmp == arr[size + i - 1][j] && tmp == arr[i][size + j - 1]
							&& tmp == arr[size + i - 1][size + j - 1]) {
						count = (int) Math.pow(size, 2);
						break Loop;
					}
				}
			}
			size--;
		}
		System.out.println(count);
	}
}