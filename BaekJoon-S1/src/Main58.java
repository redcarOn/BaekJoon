
//No.14225(부분수열의 합) - 브루트포스 + DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main58 {
	public static int N, max;
	public static int[] S;
	public static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		S = new int[N];
		max = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			max += S[i];
		}

		check = new boolean[max + 1];

		dfs(0, 0);

		for (int i = 1; i <= max; i++) {
			if (!check[i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(max + 1);
	}

	public static void dfs(int depth, int sum) {
		if (depth == N) {
			check[sum] = true;
			return;
		}

		dfs(depth + 1, sum + S[depth]);
		dfs(depth + 1, sum);
	}
}