
//No.4344
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			double sum = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			sum /= N;
			double count = 0;
			for (int j = 0; j < N; j++) {
				if (arr[j] > sum)
					count++;
			}
			String result = String.format("%.3f%%", (count / N) * 100);
			sb.append(result + "\n");
		}
		System.out.print(sb);
		br.close();
	}
}