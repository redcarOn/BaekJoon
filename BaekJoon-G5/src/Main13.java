
//No.1759(암호 만들기) - 백트래킹 + 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13 {
	public static int L, C;
	public static char[] arr;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		dfs(0, 0, 0, 0, "");

		System.out.println(sb);
	}

	public static void dfs(int start, int depth, int v, int c, String s) {
		if (depth == L) {
			if (v > 0 && c > 1) {
				sb.append(s).append('\n');
			}
			return;
		}

		for (int i = start; i < C; i++) {
			if (check(arr[i])) {
				dfs(i + 1, depth + 1, v + 1, c, s + arr[i]);
			} else {
				dfs(i + 1, depth + 1, v, c + 1, s + arr[i]);
			}
		}
	}

	public static boolean check(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}