
//No.2164
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2 * N];

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		int prev = 1;
		int last = N;

		while (N-- > 1) {
			prev++;
			arr[last + 1] = arr[prev];
			last++;
			prev++;
		}
		System.out.println(arr[prev]);
	}
}