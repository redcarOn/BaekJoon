
//No.2503
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main48 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[1000];

		for (int i = 123; i < 988; i++) {
			String num = String.valueOf(i);

			if (num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0' || num.charAt(0) == num.charAt(1)
					|| num.charAt(1) == num.charAt(2) || num.charAt(0) == num.charAt(2)) {
				continue;
			}
			check[i] = true;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			for (int j = 123; j < 988; j++) {
				if (check[j]) {
					int s = 0;
					int b = 0;

					for (int x = 0; x < 3; x++) {
						char xn = Integer.toString(num).charAt(x);

						for (int y = 0; y < 3; y++) {
							char yn = Integer.toString(j).charAt(y);

							if (xn == yn && x == y) {
								s++;
							} else if (xn == yn && x != y) {
								b++;
							}
						}
					}
					if (strike == s && ball == b) {
						check[j] = true;
					} else {
						check[j] = false;
					}
				}
			}
		}

		int count = 0;

		for (int k = 123; k < 988; k++) {
			if (check[k]) {
				count++;
			}
		}
		System.out.println(count);
	}
}