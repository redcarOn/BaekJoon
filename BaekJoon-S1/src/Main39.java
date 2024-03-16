
//No.1850(최대공약수) - 정수론
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main39 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long length = gcd(a, b);

		System.out.println("1".repeat((int) length));
	}

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
}