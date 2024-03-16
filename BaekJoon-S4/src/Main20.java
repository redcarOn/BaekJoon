
//No.1244
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (sex == 1) {
				for (int j = 1; j <= (N / num); j++) {
					arr[num * j] ^= 1;
				}
			} else {
				int front = num - 1;
				int back = num + 1;
				while (front >= 1 && back <= N) {
					if (arr[front] != arr[back]) {
						break;
					}
					front--;
					back++;
				}
				for (int k = (front + 1); k <= (back - 1); k++) {
					arr[k] ^= 1;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i] + " ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}