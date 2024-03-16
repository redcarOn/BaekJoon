
//No.11727
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main18_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		arr[1] = 1;

		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				arr[i] = (arr[i - 1] * 2 + 1) % 10007;
			} else {
				arr[i] = (arr[i - 1] * 2 - 1) % 10007;
			}
		}
		System.out.println(arr[n]);
	}
}