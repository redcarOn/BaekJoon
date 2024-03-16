//No.2609
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		System.out.println(gcd(A, B));
		System.out.println(lcm(A, B));
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return (gcd(b, a % b));
		}
	}

	public static int lcm(int a, int b) {
		return (a * b / gcd(a, b));
	}
}