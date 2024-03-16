
//No.14888(연산자 끼워넣기) - 백트래킹
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
	public static int N;
	public static int[] num;
	public static int[] func;
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		num = new int[N];
		func = new int[4];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			func[i] = Integer.parseInt(st.nextToken());
		}

		dfs(num[0], 1);

		System.out.println(max);
		System.out.println(min);

	}

	public static void dfs(int sum, int depth) {
		if (depth == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (func[i] == 0) {
				continue;
			}
			func[i]--;
			dfs(func(sum, num[depth], i), depth + 1);
			func[i]++;
		}

	}

	public static int func(int a, int b, int idx) {
		switch (idx) {
		case 0:
			a += b;
			break;

		case 1:
			a -= b;
			break;

		case 2:
			a *= b;
			break;

		case 3:
			a /= b;
			break;
		}

		return a;
	}
}