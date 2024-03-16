
//No.11653
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main09 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			if (N == 1) {
				break;
			}
			while (N % i == 0) {
				N /= i;
				sb.append(i + "\n");
			}
		}
		System.out.print(sb);
	}
}