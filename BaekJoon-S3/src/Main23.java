
//No.3273
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main23 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int x = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (search(arr, i + 1, arr.length - 1, x - arr[i])) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static boolean search(int[] arr, int start, int end, int N) {
		if (start > end) {
			return false;
		} else {
			int mid = (start + end) / 2;
			if (arr[mid] == N) {
				return true;
			} else if (arr[mid] < N) {
				return search(arr, mid + 1, end, N);
			} else {
				return search(arr, start, mid - 1, N);
			}
		}
	}
}