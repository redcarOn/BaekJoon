
//No.1629(곱셈)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
	public static long C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.println(pow(A, B));
	}

	public static long pow(long N, long E) {
		if (E == 1) {
			return N % C;
		}

		long tmp = pow(N, E / 2);

		if (E % 2 == 1) {
			return (tmp * tmp % C) * N % C;
		}

		return tmp * tmp % C;
	}
}