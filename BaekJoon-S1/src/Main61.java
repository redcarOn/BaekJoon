
//No.20529(가장 가까운 세 사람의 심리적 거리) - 브루트포스 + 비둘기집
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main61 {
	public static int N;
	public static String[] mbti;
	public static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			if (N > 32) {
				sb.append(0).append('\n');
				continue;
			}

			mbti = new String[N];
			min = 12;

			for (int j = 0; j < N; j++) {
				mbti[j] = st.nextToken();
			}

			Loop: for (int a = 0; a < N - 2; a++) {
				for (int b = a + 1; b < N - 1; b++) {
					for (int c = b + 1; c < N; c++) {
						min = Math.min(min, func(a, b, c));

						if (min == 0) {
							break Loop;
						}
					}
				}
			}
			sb.append(min).append('\n');
		}
		System.out.println(sb);
	}

	public static int func(int a, int b, int c) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			cnt += mbti[a].charAt(i) != mbti[b].charAt(i) ? 1 : 0;
			cnt += mbti[a].charAt(i) != mbti[c].charAt(i) ? 1 : 0;
			cnt += mbti[b].charAt(i) != mbti[c].charAt(i) ? 1 : 0;
		}

		return cnt;
	}
}