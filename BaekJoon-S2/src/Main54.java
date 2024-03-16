
//No.4358(생태학)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main54 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		HashMap<String, Integer> hashMap = new HashMap<>();
		String input = "";
		double sum = 0;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			hashMap.put(input, hashMap.getOrDefault(input, 0) + 1);
			sum++;
		}

		List<String> list = new ArrayList<>(hashMap.keySet());
		Collections.sort(list);

		for (String s : list) {
			double avg = hashMap.get(s) / sum * 100;
			sb.append(s).append(' ').append(String.format("%.4f", avg)).append('\n');
		}
		System.out.println(sb);
	}
}