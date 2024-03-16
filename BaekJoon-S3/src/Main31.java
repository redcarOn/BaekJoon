
//No.1735
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main31 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[2][2];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int mol = arr[0][0] * arr[1][1] + arr[1][0] * arr[0][1];
		int den = arr[0][1] * arr[1][1];

		int tmp = gcd(mol, den);
		System.out.println(mol / tmp + " " + den / tmp);
	}

	public static int gcd(int N, int M) {
		if (M == 0) {
			return N;
		} else {
			return gcd(M, N % M);
		}
	}
}