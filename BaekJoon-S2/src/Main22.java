
//No.6603
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main22 {
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
			Arrays.sort(arr);

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

		for (int i = start; i < k + start - 5; i++) {
			if (depth == 0) {
				tmp[depth] = arr[i];
				dfs(start + 1, depth + 1);
			}

			if (depth > 0 && tmp[depth - 1] < arr[i]) {
				tmp[depth] = arr[i];
				dfs(start + 1, depth + 1);
			}
		}
	}
}