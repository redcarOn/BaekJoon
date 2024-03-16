
//No.10811
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int a = 0; a < N; a++) {
			arr[a] = a + 1;
		}
		for (int a = 0; a < M; a++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			for (int b = i; b < j; b++) {
				int c = j--;
				int temp;
				temp = arr[b - 1];
				arr[b - 1] = arr[c - 1];
				arr[c - 1] = temp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < N; a++) {
			sb.append(arr[a]).append(" ");
		}
		System.out.println(sb);
	}
}