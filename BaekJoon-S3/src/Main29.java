
//No.2407
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main29 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		BigInteger mol = BigInteger.ONE;
		BigInteger den = BigInteger.ONE;
		for (int i = 0; i < M; i++) {
			mol = mol.multiply(new BigInteger(String.valueOf(N - i)));
			den = den.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		BigInteger ans = mol.divide(den);
		System.out.println(ans);
	}
}