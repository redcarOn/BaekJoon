
//No.5525(IOIOI) - 문자열★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main32 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		int cnt = 0;
		int ans = 0;

		for (int i = 1; i < M - 1; i++) {
			if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
				cnt++;

				if (cnt == N) {
					if (S.charAt(i - (cnt * 2 - 1)) == 'I') {
						ans++;
					}
					cnt--;
				}
				i++;
			} else {
				cnt = 0;
			}
		}
		System.out.println(ans);
	}
}