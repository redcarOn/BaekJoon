
//No.10815
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main09 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			int temp = binarySearch(arr, card);
			sb.append(temp + " ");
		}

		System.out.print(sb);
	}

	public static int binarySearch(int[] arr, int card) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == card) {
				return 1;
			} else {
				if (arr[mid] < card) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

		}
		return 0;
	}
}