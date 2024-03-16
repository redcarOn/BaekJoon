
//No.1934
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int lcm = A * B / gcd(A, B);
			sb.append(lcm + "\n");
		}
		System.out.print(sb);
	}

	public static int gcd(int A, int B) {
		if (B == 0) {
			return A;
		} else {
			return gcd(B, A % B);

		}
	}
}