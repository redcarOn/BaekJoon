
//No.1780
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main33 {
	public static int[][] arr;
	public static int N;
	public static int count1 = 0;
	public static int count2 = 0;
	public static int count3 = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(0, 0, N);
		sb.append(count1).append('\n').append(count2).append('\n').append(count3);

		System.out.println(sb);
	}

	public static void func(int x, int y, int size) {
		int num = arr[x][y];

		if (size == 1) {
			check(num, size);
			return;
		}

		boolean flag = true;

		Loop: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (num != arr[i][j]) {
					flag = false;
					break Loop;
				}
			}
		}
		if (!flag) {
			int nSize = size / 3;
			func(x, y, nSize);
			func(x, y + nSize, nSize);
			func(x, y + nSize * 2, nSize);
			func(x + nSize, y, nSize);
			func(x + nSize, y + nSize, nSize);
			func(x + nSize, y + nSize * 2, nSize);
			func(x + nSize * 2, y, nSize);
			func(x + nSize * 2, y + nSize, nSize);
			func(x + nSize * 2, y + nSize * 2, nSize);
		} else {
			check(num, size);
		}
	}

	public static void check(int n, int size) {
		switch (n) {
		case -1:
			count1++;
			break;
		case 0:
			count2++;
			break;
		case 1:
			count3++;
			break;
		default:
			break;
		}
	}
}