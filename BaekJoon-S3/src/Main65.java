
//No.2910
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main65 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> hMap = new LinkedHashMap<>();
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num > C) {
				continue;
			}
			hMap.put(num, hMap.getOrDefault(num, 0) + 1);

		}
		List<Integer> list = new ArrayList<>(hMap.keySet());

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(hMap.get(o2), hMap.get(o1));
			}
		});

		for (int i = 0; i < list.size(); i++) {
			int idx = list.get(i);
			for (int j = 0; j < hMap.get(idx); j++) {
				sb.append(idx).append(" ");
			}
		}
		System.out.println(sb);
	}
}