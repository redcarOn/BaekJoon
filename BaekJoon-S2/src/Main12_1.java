
//No.18870★ - 시간단축
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main12_1 {
	public static int[] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sorted = new int[N];
		tmp = new int[N];
		Map<Integer, Integer> hMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = sorted[i] = num;
		}

		mergeSort(sorted, 0, N - 1);
		int rank = 0;

		for (int val : sorted) {
			if (!hMap.containsKey(val)) {
				hMap.put(val, rank);
				rank++;
			}
		}

		for (int key : arr) {
			sb.append(hMap.get(key)).append(" ");
		}
		System.out.println(sb);
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
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
		}
	}
}