
//No.2004
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main27 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int countf = fiveCount(n) - fiveCount(n - m) - fiveCount(m);
		int counts = secondCount(n) - secondCount(n - m) - secondCount(m);

		System.out.println(Math.min(countf, counts));
	}

	public static int fiveCount(int n) {
		int count = 0;

		while (n >= 5) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}

	public static int secondCount(int n) {
		int count = 0;

		while (n >= 2) {
			count += n / 2;
			n /= 2;
		}
		return count;
	}
}