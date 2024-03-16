
//No.10819
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main42 {
	public static int N;
	public static int[] arr;
	public static int[] tmp;
	public static boolean[] visit;
	public static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		max = 0;
		DFS(0);

		System.out.println(max);
	}

	public static void DFS(int depth) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(tmp[i] - tmp[i + 1]);
			}
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				tmp[depth] = arr[i];
				DFS(depth + 1);
				visit[i] = false;
			}
		}
	}
}