
//No.18870★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sorted = new int[N];
		Map<Integer, Integer> hMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = sorted[i] = num;
		}

		Arrays.sort(sorted);
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
}