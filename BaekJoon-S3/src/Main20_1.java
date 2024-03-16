
//No.13305 - 시간단축
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[] len = new long[N - 1];
		long[] price = new long[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < len.length; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < price.length; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		long min = price[0];
		long cost = 0;

		for (int i = 0; i < N - 1; i++) {
			if (price[i] < min) {
				min = price[i];
				cost += min * len[i];
			} else {
				cost += min * len[i];
			}
		}
		System.out.println(cost);
	}
}