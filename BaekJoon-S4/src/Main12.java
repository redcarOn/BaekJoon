
//No.11399
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		minTime(arr, N);
	}

	public static void minTime(int[] arr, int N) {
		Arrays.sort(arr);
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			count += arr[i] * N;
			N--;
		}
		System.out.println(count);
	}
}