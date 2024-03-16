
//No.1759(암호 만들기) - 백트래킹 + 브루트포스(간편화)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13_1 {
	public static int L, C;
	public static char[] arr;
	public static char[] seq;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		seq = new char[L];

		arr = br.readLine().replaceAll(" ", "").toCharArray();
		Arrays.sort(arr);

		dfs(0, 0);

		System.out.println(sb);
	}

	public static void dfs(int start, int depth) {
		if (depth == L) {
			if (isVaild()) {
				sb.append(seq).append('\n');
			}
			return;
		}

		for (int i = start; i < C; i++) {
			seq[depth] = arr[i];
			dfs(i + 1, depth + 1);
		}
	}

	public static boolean isVaild() {
		int v = 0;
		int c = 0;

		for (char i : seq) {
			if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
				v++;
			} else {
				c++;
			}
		}

		if (v > 0 && c > 1) {
			return true;
		}
		return false;
	}
}