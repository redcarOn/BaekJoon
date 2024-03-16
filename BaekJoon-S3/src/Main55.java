import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main55 {
	public static int[] arr;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		find(N);

		System.out.println(sb);
	}

	public static void find(int N) {
		boolean check = true;

		Loop: for (int i = N - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				for (int j = N - 1; j >= i; j--) {
					if (arr[j] < arr[i - 1]) {
						int tmp = arr[j];
						arr[j] = arr[i - 1];
						arr[i - 1] = tmp;
						int k = N - 1;

						while (i < k) {
							int tmp2 = arr[i];
							arr[i] = arr[k];
							arr[k] = tmp2;
							i++;
							k--;
						}
						check = false;
						break Loop;
					}
				}
			}
		}

		if (check) {
			sb.append(-1);
		} else {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
		}
	}
}