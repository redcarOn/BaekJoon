
//No.1158
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arrL = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arrL.add(i + 1);
		}

		int index = K - 1;
		
		sb.append("<");
		while (true) {
			sb.append(arrL.get(index));
			arrL.remove(index);

			if (arrL.isEmpty()) {
				break;
			}

			index = (index + K - 1) % arrL.size();
			sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}