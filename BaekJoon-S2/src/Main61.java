
//No.1138(한 줄로 서기)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main61 {
	public static int N;
	public static int[] arr;
	public static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		seq = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		check();

		for (int i = 1; i <= N; i++) {
			sb.append(seq[i]).append(' ');
		}
		System.out.println(sb);
	}

	public static void check() {
		int idx = 1;

		while (idx <= N) {
			int tmp = arr[idx];

			for (int i = 1; i <= N; i++) {
				if (seq[i] == 0) {
					if (tmp == 0) {
						seq[i] = idx;
						break;
					} else {
						tmp--;
					}
				}
			}
			idx++;
		}
	}
}