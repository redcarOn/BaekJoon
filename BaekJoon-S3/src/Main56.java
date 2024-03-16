
//No.24060
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main56 {
	public static int result = -1;
	public static int count = 0;
	public static int[] tmp;
	public static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(arr, 0, arr.length - 1);
		System.out.println(result);
	}

	public static void merge_sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			merge_sort(arr, start, mid);
			merge_sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int t = start;

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				tmp[t] = arr[i];
				t++;
				i++;
			} else {
				tmp[t] = arr[j];
				t++;
				j++;
			}
		}

		while (i <= mid) {
			tmp[t] = arr[i];
			t++;
			i++;
		}

		while (j <= end) {
			tmp[t] = arr[j];
			t++;
			j++;
		}
		for (int a = start; a <= end; a++) {
			arr[a] = tmp[a];
			count++;
			if (count == K) {
				result = arr[a];
				break;
			}
		}
	}
}