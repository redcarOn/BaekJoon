
//No.9461
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[101];
		arr[1] = arr[2] = arr[3] = 1;
		arr[4] = 2;

		for (int i = 5; i < 101; i++) {
			arr[i] = arr[i - 1] + arr[i - 5];
		}

		for (int i = 0; i < T; i++) {
			sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(sb);
	}
}