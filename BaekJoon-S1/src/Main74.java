
//No.2824(최대공약수) - BigInteger
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main74 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		BigInteger A = new BigInteger("1");

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A = A.multiply(new BigInteger(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		BigInteger B = new BigInteger("1");

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B = B.multiply(new BigInteger(st.nextToken()));
		}

		String ans = A.gcd(B).toString();

		if (ans.length() > 9) {
			for (int i = 0; i < 9; i++) {
				sb.append(ans.charAt(ans.length() - 9 + i));
			}
		} else {
			sb.append(ans);
		}

		System.out.println(sb);
	}
}