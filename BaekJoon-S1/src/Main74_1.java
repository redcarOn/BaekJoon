
//No.2824(최대공약수) - HashMap
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main74_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Map<Integer, Integer> aMap, bMap;
		int N = Integer.parseInt(br.readLine());
		aMap = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			func(num, aMap);
		}

		int M = Integer.parseInt(br.readLine());
		bMap = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			func(num, bMap);
		}

		boolean flag = false;
		long gcd = 1L;

		for (int key : aMap.keySet()) {
			if (bMap.containsKey(key)) {
				int min = Math.min(aMap.get(key), bMap.get(key));

				for (int i = 0; i < min; i++) {
					gcd *= key;

					if (gcd >= 1000000000) {
						gcd %= 1000000000;
						flag = true;
					}
				}
			}
		}

		if (flag) {
			System.out.printf("%09d", gcd);
			return;
		}

		System.out.println(gcd);
	}

	public static void func(int num, Map<Integer, Integer> Map) {
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			while (num % i == 0) {
				Map.put(i, Map.getOrDefault(i, 0) + 1);
				num /= i;
			}
		}

		if (num != 1) {
			Map.put(num, Map.getOrDefault(num, 0) + 1);
		}
	}
}