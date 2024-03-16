
//No.14225(부분수열의 합) - 간편화버전
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main58_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(S);
		int num = 1;

		for (int i = 0; i < N; i++) {
			if (S[i] > num) {
				break;
			}
			num += S[i];
		}
		System.out.println(num);
	}
}