
//NO.2961(도영이가 만든 맛있는 음식) - 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main57 {
	public static int[] sour;
	public static int[] bit;
	public static int N;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bit = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bit[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 1, 0, 0);

		System.out.println(min);
	}

	public static void dfs(int depth, int s, int b, int cnt) {
		if (depth == N) {
			if (cnt != 0) {
				min = Math.min(min, Math.abs(s - b));
			}
			return;
		}

		dfs(depth + 1, s * sour[depth], b + bit[depth], cnt + 1);
		dfs(depth + 1, s, b, cnt);
	}
}