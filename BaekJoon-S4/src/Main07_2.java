
//No.10816
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[20000001];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			arr[card + 10000000]++;
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			sb.append(arr[card + 10000000]).append(" ");
		}
		System.out.println(sb);
	}
}