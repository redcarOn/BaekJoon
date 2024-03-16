
//No.16139(인간-컴퓨터 상호작용) - 누적합
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main43 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();
		int[][] s = new int[S.length() + 1][26];
		s[1][S.charAt(0) - 'a']++;

		for (int i = 2; i <= S.length(); i++) {
			for (int j = 0; j < 26; j++) {
				s[i][j] = s[i - 1][j];
			}
			s[i][S.charAt(i - 1) - 'a']++;
		}

		int q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()) + 1;

			sb.append(s[end][c] - s[start][c]).append('\n');
		}

		System.out.println(sb);
	}
}