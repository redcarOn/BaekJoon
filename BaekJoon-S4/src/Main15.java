
//No.1764
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main15 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> hSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			hSet.add(br.readLine());
		}

		int count = 0;
		ArrayList<String> arrL = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (hSet.contains(s)) {
				count++;
				arrL.add(s);
			}
		}
		Collections.sort(arrL);
		
		sb.append(count).append("\n");
		for (int i = 0; i < arrL.size(); i++) {
			sb.append(arrL.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}