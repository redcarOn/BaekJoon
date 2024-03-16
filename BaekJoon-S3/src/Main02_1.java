
//No.1929
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02_1 {
	public static boolean[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new boolean[N + 1];

		find();

		for (int i = M; i <= N; i++) {
			if (!arr[i]) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static void find() {
		arr[0] = arr[1] = true;

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i * i; j < arr.length; j = j + i) {
				arr[j] = true;
			}
		}
	}
}