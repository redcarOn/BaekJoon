
//No.6603
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main22_1 {
	public static StringBuilder sb;
	public static int[] arr;
	public static int[] tmp;
	public static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		String input = "";

		while (!(input = br.readLine()).equals("0")) {
			st = new StringTokenizer(input);
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			tmp = new int[6];

			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);
			sb.append('\n');
		}
		System.out.println(sb);

	}

	public static void dfs(int start, int depth) {
		if (depth == 6) {
			for (int val : tmp) {
				sb.append(val).append(" ");
			}
			sb.append('\n');
			return;
		}

		if (start == k) {
			return;
		}

		tmp[depth] = arr[start];

		dfs(start + 1, depth + 1);
		dfs(start + 1, depth);
	}
}