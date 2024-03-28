
//No.14891(톱니바퀴) - 구현(배열)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main32 {
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[5][8];

		for (int i = 1; i <= 4; i++) {
			String s = br.readLine();

			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			func(num, dir);
		}

		int ans = 0;

		for (int i = 1; i <= 4; i++) {
			if (arr[i][0] == 1) {
				ans += Math.pow(2, i - 1);
			}
		}

		System.out.println(ans);
	}

	public static void func(int num, int dir) {
		leftSide(num - 1, -dir);
		rightSide(num + 1, -dir);
		rotate(num, dir);
	}

	public static void leftSide(int num, int dir) {
		if (num < 1) {
			return;
		}
		if (arr[num][2] == arr[num + 1][6]) {
			return;
		}
		leftSide(num - 1, -dir);
		rotate(num, dir);
	}

	public static void rightSide(int num, int dir) {
		if (num > 4) {
			return;
		}
		if (arr[num][6] == arr[num - 1][2]) {
			return;
		}
		rightSide(num + 1, -dir);
		rotate(num, dir);
	}

	public static void rotate(int num, int dir) {
		if (dir == 1) {
			int tmp = arr[num][7];

			for (int i = 7; i > 0; i--) {
				arr[num][i] = arr[num][i - 1];
			}
			arr[num][0] = tmp;
		} else {
			int tmp = arr[num][0];

			for (int i = 0; i < 7; i++) {
				arr[num][i] = arr[num][i + 1];
			}
			arr[num][7] = tmp;
		}
	}
}