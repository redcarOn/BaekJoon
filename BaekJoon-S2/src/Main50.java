
//No.12891(DNA 비밀번호)★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main50 {
	public static int[] req;
	public static int[] check;
	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이

		char[] str = br.readLine().toCharArray();

		req = new int[4]; // 문자 최소 개수
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++) {
			req[i] = Integer.parseInt(st.nextToken());

			if (req[i] == 0) {
				cnt++;
			}
		}

		int answer = 0; // 갯수
		check = new int[4]; // 문자

		for (int i = 0; i < P; i++) {
			plus(str[i]);
		}

		if (cnt == 4) {
			answer++;
		}

		for (int i = P; i < S; i++) {
			int start = i - P;
			minus(str[start]);
			plus(str[i]);

			if (cnt == 4) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void plus(char c) {
		switch (c) {
		case 'A':
			check[0]++;
			if (check[0] == req[0]) {
				cnt++;
			}
			break;

		case 'C':
			check[1]++;
			if (check[1] == req[1]) {
				cnt++;
			}
			break;

		case 'G':
			check[2]++;
			if (check[2] == req[2]) {
				cnt++;
			}
			break;

		case 'T':
			check[3]++;
			if (check[3] == req[3]) {
				cnt++;
			}
			break;
		}
	}

	public static void minus(char c) {
		switch (c) {
		case 'A':
			if (check[0] == req[0]) {
				cnt--;
			}
			check[0]--;
			break;

		case 'C':
			if (check[1] == req[1]) {
				cnt--;
			}
			check[1]--;
			break;

		case 'G':
			if (check[2] == req[2]) {
				cnt--;
			}
			check[2]--;
			break;

		case 'T':
			if (check[3] == req[3]) {
				cnt--;
			}
			check[3]--;
			break;
		}
	}
}