
//No.11652
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main25 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> hMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			hMap.put(num, hMap.getOrDefault(num, 0) + 1);
		}

		Set<Long> card = hMap.keySet();
		int count = 0;
		long num = 0;

		for (long key : card) {
			if (count < hMap.get(key)) {
				count = hMap.get(key);
				num = key;
			} else if (count == hMap.get(key)) {
				num = Math.min(num, key);
				count = hMap.get(key);
			}
		}
		System.out.println(String.valueOf(num));
	}
}