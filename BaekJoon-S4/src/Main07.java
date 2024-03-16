
//No.10816
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main07 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> hMap = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
			sb.append(hMap.getOrDefault(arr2[i], 0)).append(" ");
		}

		System.out.println(sb);
	}
}